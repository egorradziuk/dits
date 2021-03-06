package com.dev_incubator.dits.controller;

import com.dev_incubator.dits.config.security.CustomUserDetails;
import com.dev_incubator.dits.persistence.entity.AnswerY;
import com.dev_incubator.dits.persistence.entity.QuestionY;
import com.dev_incubator.dits.persistence.entity.StatisticY;
import com.dev_incubator.dits.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class TestPageControllerY {

    private static int counter;
    private static CustomUserDetails user;
    private static int max;
    private static Timestamp date;
    private static List<QuestionY> questionList;

    @Autowired
    private UserServiceY userService;

    @Autowired
    private TestServiceY testService;

    @Autowired
    private QuestionServiceY questionService;

    @Autowired
    private AnswerServiceY answerService;

    @Autowired
    private StatisticServiceY statisticService;


    @GetMapping(value = "/goTest")
    public String goTest(@RequestParam String testName, ModelMap modelMap) {
        clearCounter();
        initVariables(testName);
        fillTestDB();
        if (questionList != null) {
            modelMap.addAttribute("questions", questionList.get(counter)
                    .getDescription());
            modelMap.addAttribute("answers", questionService.getAnswersByQuestionId
                    (questionList.get(counter).getId()));
        }
        return "testPageY";
    }

    @GetMapping(value = "/nextTestPage")
    public String nextTestPage1(
            @RequestParam(value = "choosenAns", defaultValue = "-1") Long id,
            ModelMap modelMap) {
        if (id != -1) {
            changeCorrectValue(answerService.getCorrectByDescription(id));
        }
        counter++;
        if (counter < max) {
            modelMap.addAttribute("questions", questionList.get(counter)
                    .getDescription());
            modelMap.addAttribute("answers", questionService.getAnswersByQuestionId
                    (questionList.get(counter).getId()));

            return "testPageY";
        } else {
            return resultPageFill(modelMap);
        }
    }

    @GetMapping("/resultPage")
    public String resultPageFill(ModelMap modelMap) {
        clearCounter();
        modelMap.addAttribute("statistic",
                statisticService.getAllByDate(date));
        return "resultPageY";
    }

    @GetMapping(value = "/logout")
    public String logout() {
        /*fillTestDB();
        statisticService.saveMapOfStat(StatisticService.statList, Calendar.getInstance().getTime());*/
        clearCounter();
        return "main";
    }

    private void initVariables(String testName) {
        user = (CustomUserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        date = new Timestamp(new Date().getTime());
        StatisticServiceY.statList.clear();
        questionList = testService.getQuestionsByTestName(testName);
        max = questionList.size();
    }

    private StatisticY configureStatistic() {
        StatisticY statistic = new StatisticY();
        statistic.setCorrect(false);
        statistic.setQuestionY(questionList.get(counter));
        statistic.setUserY(userService.findUserById(user.getId()));
        statistic.setDate(date);
        return statistic;
    }

    void fillTestDB() {
        while (StatisticServiceY.statList.size() != max) {
            statisticService.statList
                    .put(String.valueOf(questionList.get(counter)
                            .getId()), configureStatistic());
            counter++;
        }
        statisticService.saveMapOfStat(StatisticServiceY.statList, date);
        clearCounter();
    }

    private void changeCorrectValue(AnswerY answer) {
        if (answer.isCorrect()) {
            statisticService.changeCorrectValue(date, userService
                            .findUserById(user.getId()),
                    questionList.get(counter), answer.isCorrect());
        }
    }

    private void clearCounter() {
        counter = 0;
    }

}
