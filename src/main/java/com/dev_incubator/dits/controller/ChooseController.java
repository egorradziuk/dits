package com.dev_incubator.dits.controller;

import com.dev_incubator.dits.persistence.entity.Topic;
import com.dev_incubator.dits.persistence.entity.TopicY;
import com.dev_incubator.dits.service.interfaces.TestServiceY;
import com.dev_incubator.dits.service.interfaces.TopicService;
import com.dev_incubator.dits.service.interfaces.TopicServiceY;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@AllArgsConstructor
public class ChooseController {


    private final TopicServiceY topicService;

    private final TestServiceY testService;

    @GetMapping(value = "/userChoose", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> searchTestName(@RequestParam(value = "topic",
            required = false) String topic) {
        List<String> list = topicService.findTestsByTopicY(topic);
        return list;
    }

    @GetMapping(value = "/getThemes")
    public String goTest(@RequestParam(value = "topic", required = false)
                                 TopicY topic, Model model) {
        model.addAttribute("tests", testService.findAll());
        return "testPage";
    }

}
