package controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Dmitry on 19.02.2018.
 */
@Controller
public class CreateUserController {

    @RequestMapping(value = "/create-user", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("UserHome", "user", new User());
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("user") User user,
                             BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("role", user.getRole());
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("login", user.getLogin());
        model.addAttribute("password", user.getPassword());
        return "userView";
    }
}
