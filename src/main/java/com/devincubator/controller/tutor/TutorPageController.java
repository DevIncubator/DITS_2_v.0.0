package com.devincubator.controller.tutor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Main page controller for tutor
 *
 * @author Alex V.
 */

@Controller
@RequestMapping("/tutor")
public class TutorPageController {

    @RequestMapping(value = "/tutor-main-page", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("/tutor/tutor-main-page");
    }
}