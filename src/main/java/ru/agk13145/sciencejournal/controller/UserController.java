package ru.agk13145.sciencejournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.agk13145.sciencejournal.model.User;
import ru.agk13145.sciencejournal.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/author/{agentId}" , method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> getAuthor(@PathVariable String agentId) {
        User agent = userService.getUser(Integer.parseInt(agentId));
        return new ResponseEntity<>(agent, HttpStatus.OK);
    }

}