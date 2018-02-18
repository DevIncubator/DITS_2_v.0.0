package controller;

import entity.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Dmitry on 18.02.2018.
 */

@Controller
public class CreateTestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("testHome", "test", new Test());
    }

    @RequestMapping(value = "/addTest", method = RequestMethod.POST)
    public String submit(@ModelAttribute("test")Test test,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("topic", test.getTopic());
        model.addAttribute("name", test.getName());
        return "employeeView";
    }
}
