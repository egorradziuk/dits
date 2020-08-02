//package by.radziuk.devincubator.controller;
//
//import by.radziuk.devincubator.service.TestService;
//import by.radziuk.devincubator.service.TopicService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class StartController {
//
//    @Autowired
//    private TopicService topicService;
//
//    @Autowired
//    private TestService testService;
//
//    @GetMapping(value = "/")
//    public String user() {
//        return "User/user";
//    }
//
//    @GetMapping(value = "/chooseTest")
//    public String ChooseTest(Model model) {
//        model.addAttribute("topics", topicService.findAll());
//        return "User/userChoose";
//    }
//
//    @GetMapping(value = "/personalStatistic")
//    public String personalStatisticPage() {
//        return "User/personalStatistic";
//    }
//
//}
