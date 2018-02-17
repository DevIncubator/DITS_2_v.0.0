package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.AbstractService;

/**
 * Created by Dmitry on 17.02.2018.
 */

@Controller
public class UserController {

    private AbstractService abstractService;

    @Autowired(required = true)
    @Qualifier(value = "abstractService")
    public void setAbstractService(AbstractService abstractService) {
        this.abstractService = abstractService;
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.abstractService.getAll());
        return "user";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String create(@ModelAttribute("user") User user) {
        if (user.getUserId() == 0) {
            this.abstractService.create(user);
        } else {
            this.abstractService.update(user);
        }
        return "redirect:/users";
    }

    @RequestMapping("/remove/{userId}")
    public String removeUser(@PathVariable("userId") int userId) {
        this.abstractService.remove(userId);
        return "redirect:/users";
    }

}

