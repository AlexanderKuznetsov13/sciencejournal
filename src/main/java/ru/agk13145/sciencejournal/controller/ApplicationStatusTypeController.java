package ru.agk13145.sciencejournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.agk13145.sciencejournal.model.ApplicationStatusType;
import ru.agk13145.sciencejournal.service.ApplicationStatusTypeService;

import java.util.List;

@Controller
@RequestMapping(value = "/applicationstatustypes", produces = "application/json;charset=UTF-8")
public class ApplicationStatusTypeController {

    @Autowired
    private ApplicationStatusTypeService applicationStatusTypeService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<ApplicationStatusType>> getApplicationStatusTypes() {
        List<ApplicationStatusType> applicationStatusTypes = applicationStatusTypeService.getApplicationStatusTypes();
        return new ResponseEntity<>(applicationStatusTypes, HttpStatus.OK);
    }

    @GetMapping(value = "/{applicationStatusTypeId}")
    @ResponseBody
    public ResponseEntity<ApplicationStatusType> getApplicationStatusType(@PathVariable Integer applicationStatusTypeId) {
        ApplicationStatusType applicationStatusType = applicationStatusTypeService.getApplicationStatusType(applicationStatusTypeId);
        return new ResponseEntity<>(applicationStatusType, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<ApplicationStatusType> createApplicationStatusType(@RequestBody ApplicationStatusType applicationStatusType) {
        Integer applicationStatusTypeId = applicationStatusTypeService.createApplicationStatusType(applicationStatusType);
        applicationStatusType = applicationStatusTypeService.getApplicationStatusType(applicationStatusTypeId);
        return new ResponseEntity<>(applicationStatusType, HttpStatus.OK);
    }

    @PutMapping(value = "/{applicationStatusTypeId}")
    @ResponseBody
    public ResponseEntity<ApplicationStatusType> updateApplicationStatusType(@PathVariable Integer applicationStatusTypeId, @RequestBody ApplicationStatusType applicationStatusType) {
        applicationStatusType.setId(applicationStatusTypeId);
        applicationStatusTypeService.updateApplicationStatusType(applicationStatusType);
        return new ResponseEntity<>(applicationStatusType, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{applicationStatusTypeId}")
    public ResponseEntity<Integer> deleteApplicationStatusType(@PathVariable Integer applicationStatusTypeId) {
        applicationStatusTypeService.deleteApplicationStatusType(applicationStatusTypeId);
        return new ResponseEntity<>(applicationStatusTypeId, HttpStatus.OK);
    }

}
