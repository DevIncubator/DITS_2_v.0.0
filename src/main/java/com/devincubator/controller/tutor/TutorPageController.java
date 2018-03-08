package com.devincubator.controller.tutor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TutorPageController {

    @RequestMapping(value = "/tutor-main-page", method = RequestMethod.GET)
    public ModelAndView showForm() {
        ModelAndView model = new ModelAndView("tutor/tutor-main-page");
        return model;
    }

    @RequestMapping(value = "/edit-theme-test", method = RequestMethod.GET)
    public String goToEditThemeTest(){
        return "tutor/edit-theme-test";
    }

    @RequestMapping(value = "/edit-question", method = RequestMethod.GET)
    public String goToCreateQuestion() {
        return "tutor/create-question";
    }

    @RequestMapping(value = "/tutor-statistic", method = RequestMethod.GET)
    public String goToStatistic() {
        return "tutor/tutor-statistics";
    }
}