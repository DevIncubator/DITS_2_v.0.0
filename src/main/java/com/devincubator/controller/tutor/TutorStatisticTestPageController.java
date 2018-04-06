package com.devincubator.controller.tutor;

import com.devincubator.entity.TestStatistic;
import com.devincubator.service.TestStatisticServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TutorStatisticTestPageController {

    @Autowired
    private TestStatisticServiceImpl testStatisticServiceImpl;

    @RequestMapping(value = "/tutor/tutor-statistics-test", method = RequestMethod.GET)
    public ModelAndView showViews() {
        ModelAndView model = new ModelAndView("/tutor/tutor-statistic-test");
        List<TestStatistic> testStatistic = testStatisticServiceImpl.getAll();
        model.addObject("stat", testStatistic);
        return model;
    }
}
