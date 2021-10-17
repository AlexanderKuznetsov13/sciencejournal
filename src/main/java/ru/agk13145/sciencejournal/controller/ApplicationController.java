package ru.agk13145.sciencejournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.agk13145.sciencejournal.model.Application;
import ru.agk13145.sciencejournal.model.ApplicationWithDetails;
import ru.agk13145.sciencejournal.service.ApplicationService;

import java.util.List;

@Controller
@RequestMapping(value = "/applications", produces = "application/json;charset=UTF-8")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Application>> getApplications() {
        List<Application> applications = applicationService.getApplications();
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @GetMapping(value = "/{applicationId}")
    @ResponseBody
    public ResponseEntity<Application> getApplication(@PathVariable Integer applicationId) {
        Application application = applicationService.getApplication(applicationId);
        return new ResponseEntity<>(application, HttpStatus.OK);
    }

    @GetMapping(value = "/{applicationId}/detailed")
    @ResponseBody
    public ResponseEntity<ApplicationWithDetails> getApplicationWithDetails(@PathVariable Integer applicationId) {
        ApplicationWithDetails applicationWithDetails = applicationService.getApplicationWithDetails(applicationId);
        return new ResponseEntity<>(applicationWithDetails, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Application> createApplication(@RequestBody Application application) {
        Integer applicationId = applicationService.createApplication(application);
        application = applicationService.getApplication(applicationId);
        return new ResponseEntity<>(application, HttpStatus.OK);
    }

    @PutMapping(value = "/{applicationId}")
    @ResponseBody
    public ResponseEntity<Application> updateApplication(@PathVariable Integer applicationId, @RequestBody Application application) {
        application.setId(applicationId);
        applicationService.updateApplication(application);
        return new ResponseEntity<>(application, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{applicationId}")
    public ResponseEntity<Integer> deleteApplication(@PathVariable Integer applicationId) {
        applicationService.deleteApplication(applicationId);
        return new ResponseEntity<>(applicationId, HttpStatus.OK);
    }

}
