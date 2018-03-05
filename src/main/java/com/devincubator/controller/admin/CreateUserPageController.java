package com.devincubator.controller.admin;

import com.devincubator.dto.UserRoleDTO;
import com.devincubator.entity.Role;
import com.devincubator.entity.User;
import com.devincubator.service.RoleServiceImpl;
import com.devincubator.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Dmitry on 05.03.2018.
 */
public class CreateUserPageController {

    @Autowired
    private UserServiceImpl userServiceImpl;


    @RequestMapping(value = "/create-user", method = RequestMethod.GET)
    public ModelAndView showForm() {
        ModelAndView model = new ModelAndView("admin/create-user");
        model.addObject("user", new User());
        UserRoleDTO[] roles = UserRoleDTO.values();
        List<String> roleNames = new ArrayList<>();
        for (UserRoleDTO role : roles) {
            roleNames.add(role.getName());
        }
        model.addObject("roleNames", roleNames);
        return model;
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public ModelAndView submitForm(@ModelAttribute("user") User user) {
        userServiceImpl.create(user);
        return showForm();
    }
}
