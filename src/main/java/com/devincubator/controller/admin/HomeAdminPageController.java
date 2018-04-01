package com.devincubator.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeAdminPageController {

    @RequestMapping(value = "/admin-home", method = RequestMethod.GET)
    public ModelAndView showView() {
        ModelAndView model = new ModelAndView("admin/admin-home");
        return model;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String goToCreateTest() {
        return "admin/create-test";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String goToCreateUser() {
        return "admin/create-user";
    }

    @RequestMapping(value = "/statistic", method = RequestMethod.GET)
    public String goToStatistic() {
        return "admin/statistics";
    }
}
