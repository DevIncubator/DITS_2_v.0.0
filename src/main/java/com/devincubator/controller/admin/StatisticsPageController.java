package com.devincubator.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Dmitry on 28.02.2018.
 */
@Controller
@RequestMapping(value = "/admin")
public class StatisticsPageController {
    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public ModelAndView showViews() {
        ModelAndView model = new ModelAndView("admin/statistics");
        return model;
    }

    @RequestMapping(value = "/statistic-test", method = RequestMethod.GET)
    public String goToStatisticTest() {
        return "admin/statistic-test";
    }

    @RequestMapping(value = "/statistic-user", method = RequestMethod.GET)
    public String goToStatisticUser() {
        return "admin/statistic-user";
    }

    @RequestMapping(value = "/statistic-questions", method = RequestMethod.GET)
    public String goToStatisticQuestions() {
        return "admin/statistic-questions";
    }
}
