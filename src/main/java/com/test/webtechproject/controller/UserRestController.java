package com.test.webtechproject.controller;

import com.test.webtechproject.model.User;
import com.test.webtechproject.data.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    UserDAO userDAO;

    @GetMapping("/json/users")
    public List<User>UserList(){
        return (List<User>) userDAO.findAll();
    }
    @PostMapping("/json/users")
    public void saveUser(@RequestBody User user){
        userDAO.save(user);
    }
}
