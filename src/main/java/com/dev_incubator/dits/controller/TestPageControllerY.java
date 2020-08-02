package com.dev_incubator.dits.controller;

import com.dev_incubator.dits.persistence.entity.AnswerY;
import com.dev_incubator.dits.persistence.entity.QuestionY;
import com.dev_incubator.dits.persistence.entity.StatisticY;
import com.dev_incubator.dits.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class TestPageControllerY {

    private static int counter;
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
        Date date1;
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MILLISECOND, 0);
        date1 = c.getTime();
        date = new Timestamp(date1.getTime());

        System.out.println("init date " + date);
        StatisticServiceY.statList.clear();
        questionList = testService.getQuestionsByTestName(testName);
        max = questionList.size();
        addSomePart();
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
            @RequestParam(value = "choosenAns", defaultValue = "-1") int id,
            ModelMap modelMap) {
        boolean correct = false;
        if (id != -1) {
            AnswerY answer = answerService.getCorrectByDescription(id);
            correct = answer.isCorrect();
            if (correct) {
                statisticService.changeCorrectValue(date, userService
                                .findUserById(1),
                        questionList.get(counter), correct);
            }
            System.out.println("correct = " + correct);
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

    private StatisticY configureStatistic() {
        StatisticY statistic = new StatisticY();
        statistic.setCorrect(false);
        statistic.setQuestionY(questionList.get(counter));
        statistic.setUserY(userService.findUserById(1));
        statistic.setDate(date);
        return statistic;
    }


    @GetMapping("/resultPage")
    public String resultPageFill(ModelMap modelMap) {
        counter = 0;
        modelMap.addAttribute("statistic",
                statisticService.getAllByDate(date));
        System.out.println("resultPage " + date);
        return "resultPageY";
    }

    @GetMapping(value = "/logout")
    public String logout() {
        /*addSomePart();
        statisticService.saveMapOfStat(StatisticService.statList, Calendar.getInstance().getTime());*/
        counter = 0;
        return "main";
    }

    void addSomePart() {
        int id = -1;
        while (StatisticServiceY.statList.size() != max) {
            statisticService.statList
                    .put(String.valueOf(questionList.get(counter)
                            .getId()), configureStatistic());
            counter++;
        }
        statisticService.saveMapOfStat(StatisticServiceY.statList, date);
        counter = 0;
    }

}
