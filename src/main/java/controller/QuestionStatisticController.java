package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Dmitry on 19.02.2018.
 */
@Controller
public class QuestionStatisticController {

    @RequestMapping(value = "/test-statistic", method = RequestMethod.GET)
    public List showQuestionStatistic() {
        return ""
    }


}
