//package by.radziuk.devincubator.controller;
//
//import by.radziuk.devincubator.model.Test;
//import by.radziuk.devincubator.model.Topic;
//import by.radziuk.devincubator.service.TestService;
//import by.radziuk.devincubator.service.TopicService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//
//@Controller
//public class ChooseController {
//
//    @Autowired
//    private TopicService topicService;
//
//    @Autowired
//    private TestService testService;
//
//    @GetMapping(value = "/userChoose", produces = APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public List<String> searchTestName(@RequestParam(value = "topic",
//            required = false) String topic) {
//        return topicService.findTestsByTopic(topic);
//    }
//
//    @GetMapping(value = "/getThemes")
//    public String goTest(@RequestParam(value = "topic", required = false)
//                                     Topic topic, Model model) {
//        model.addAttribute("tests", testService.findAll());
//        return "User/testPage";
//    }
//
//}
