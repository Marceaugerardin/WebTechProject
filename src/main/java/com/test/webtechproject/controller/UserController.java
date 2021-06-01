package com.test.webtechproject.controller;

import com.test.webtechproject.data.UserDAO;
import com.test.webtechproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UserController {

    private final UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/user")
    public String showUser(Model model) {
        model.addAttribute("userList", userDAO.findAll());
        model.addAttribute("newUser", new User());

        return "UserSignInPage";
    }


    @PostMapping("/user")
    public String getUser(@ModelAttribute User newUser) {
        User user = new User(newUser.getUsername(),newUser.getSurname(), newUser.getLastName(), newUser.getUserRanking(), newUser.getMail(), newUser.getPassword(),
                newUser.getComment(), newUser.getItem(), newUser.getGivenOffer(), newUser.getTakenOffer());
        userDAO.save(user);

        return "redirect:user";
    }
}