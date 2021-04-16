package ru.agk13145.sciencejournal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/author/{agentId}" , method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getAuthor(@PathVariable String agentId) {
        return new ResponseEntity<>(agentId, HttpStatus.OK);
    }

}