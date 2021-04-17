package ru.agk13145.sciencejournal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.agk13145.sciencejournal.model.UserType;
import ru.agk13145.sciencejournal.service.UsertypeService;

import java.util.List;

@Controller
@RequestMapping(value = "/usertypes", produces = "application/json;charset=UTF-8")
public class UserTypeController {

    @Autowired
    private UsertypeService usertypeService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<UserType>> getUserTypes() {
        List<UserType> usertype = usertypeService.getUserTypes();
        return new ResponseEntity<>(usertype, HttpStatus.OK);
    }

    @GetMapping(value = "/{usertypeId}")
    @ResponseBody
    public ResponseEntity<UserType> getLanguage(@PathVariable Integer usertypeId) {
        UserType usertype = usertypeService.getUserType(usertypeId);
        return new ResponseEntity<>(usertype, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<UserType> createLanguage(@RequestBody UserType usertype) {
        Integer usertypeId = usertypeService.createUserType(usertype);
        usertype = usertypeService.getUserType(usertypeId);
        return new ResponseEntity<>(usertype, HttpStatus.OK);
    }

    @PutMapping(value = "/{usertypeId}")
    @ResponseBody
    public ResponseEntity<UserType> updateUserType(@PathVariable Integer usertypeId, @RequestBody UserType usertype) {
        usertype.setId(usertypeId);
        usertypeService.updateUserType(usertype);
        return new ResponseEntity<>(usertype, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{usertypeId}")
    public ResponseEntity<Integer> deleteUserType(@PathVariable Integer usertypeId) {
        usertypeService.deleteUserType(usertypeId);
        return new ResponseEntity<>(usertypeId, HttpStatus.OK);
    }

}
