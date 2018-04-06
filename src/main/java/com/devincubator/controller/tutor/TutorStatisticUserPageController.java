package com.devincubator.controller.tutor;

import com.devincubator.entity.UserStatistic;
import com.devincubator.service.UserStatisticServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/tutor")
public class TutorStatisticUserPageController {

    @Autowired
    private UserStatisticServiceImpl userStatisticServiceImpl;

    @RequestMapping(value = "/tutor-statistics-user", method = RequestMethod.GET)
    public ModelAndView showViews() {
        ModelAndView model = new ModelAndView("/tutor/tutor-statistic-user");
        List<UserStatistic> userStatistic;
        userStatistic = userStatisticServiceImpl.getAll();
        model.addObject("stat", userStatistic);
        return model;
    }
}
