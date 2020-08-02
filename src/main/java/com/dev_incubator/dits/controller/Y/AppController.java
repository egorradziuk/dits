//package by.radziuk.devincubator.controller;
//
//import by.radziuk.devincubator.service.QuestionService;
//import by.radziuk.devincubator.service.StatisticService;
//import by.radziuk.devincubator.service.TestService;
//import by.radziuk.devincubator.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//public class AppController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private QuestionService questionService;
//
//    @Autowired
//    private StatisticService statisticService;
//
//    @Autowired
//    private TestService testServices;
//
//    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
//    public String listUsers(ModelMap model) {
////        model.addAttribute("users", testServices.findTestsByTopic(2));
//        //userService.findAllUsers());
//        model.addAttribute("questions", questionService.findAllQuestions());
//        model.addAttribute("statistics", statisticService.findAllStatistics());
//        return "allusers";
//    }
//
//}
