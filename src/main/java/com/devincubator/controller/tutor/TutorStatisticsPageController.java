package com.devincubator.controller.tutor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tutor")
public class TutorStatisticsPageController {
    @RequestMapping(value = "/tutor-statistics", method = RequestMethod.GET)
    public ModelAndView showViews() {
        ModelAndView model = new ModelAndView("/tutor/tutor-statistics");
        return model;
    }

    @RequestMapping(value = "/tutor-statistic-test", method = RequestMethod.GET)
    public String goToStatisticTest() {
        return "/tutor/tutor-statistic-test";
    }

    @RequestMapping(value = "/tutor-statistic-user", method = RequestMethod.GET)
    public String goToStatisticUser() {
        return "/tutor/tutor-statistic-user";
    }

    @RequestMapping(value = "/tutor-statistic-questions", method = RequestMethod.GET)
    public String goToStatisticQuestions() {
        return "/tutor/tutor-statistic-questions";
    }
}
