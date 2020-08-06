package com.dev_incubator.dits.controller;

import com.dev_incubator.dits.service.interfaces.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class StartController {

    private final TopicService topicService;

//    private final TestService testService;

    @GetMapping(value = "/userTest")
    public String user() {
        return "userTest";
    }


    @GetMapping(value = "/personalStatistic")
    public String personalStatisticPage() {
        return "personalStatistic";
    }

}
