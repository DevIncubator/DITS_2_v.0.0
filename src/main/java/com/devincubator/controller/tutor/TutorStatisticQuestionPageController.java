package com.devincubator.controller.tutor;

import com.devincubator.entity.QuestionStatistic;
import com.devincubator.service.QuestionStatisticServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TutorStatisticQuestionPageController {

    @Autowired
    private QuestionStatisticServiceImpl questionStatisticServiceImpl;

    @RequestMapping(value = "/tutor/tutor-statistics-questions", method = RequestMethod.GET)
    public ModelAndView showViews() {
        ModelAndView model = new ModelAndView("/tutor/tutor-statistic-questions");
        List<QuestionStatistic> questionStatistic = questionStatisticServiceImpl.getAll();
        model.addObject("stat", questionStatistic);
        return model;
    }
}
