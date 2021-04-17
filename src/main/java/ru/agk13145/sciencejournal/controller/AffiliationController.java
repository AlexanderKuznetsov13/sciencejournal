package ru.agk13145.sciencejournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.agk13145.sciencejournal.model.Affiliation;
import ru.agk13145.sciencejournal.service.AffiliationService;

import java.util.List;

@Controller
@RequestMapping(value = "/affiliations", produces = "application/json;charset=UTF-8")
public class AffiliationController {

    @Autowired
    private AffiliationService affiliationService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Affiliation>> getAffiliations() {
        List<Affiliation> affiliations = affiliationService.getAffiliations();
        return new ResponseEntity<>(affiliations, HttpStatus.OK);
    }

    @GetMapping(value = "/{affiliationId}")
    @ResponseBody
    public ResponseEntity<Affiliation> getAffiliation(@PathVariable Integer affiliationId) {
        Affiliation affiliation = affiliationService.getAffiliation(affiliationId);
        return new ResponseEntity<>(affiliation, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Affiliation> createAffiliation(@RequestBody Affiliation affiliation) {
        Integer affiliationId = affiliationService.createAffiliation(affiliation);
        affiliation = affiliationService.getAffiliation(affiliationId);
        return new ResponseEntity<>(affiliation, HttpStatus.OK);
    }

    @PutMapping(value = "/{affiliationId}")
    @ResponseBody
    public ResponseEntity<Affiliation> updateAffiliation(@PathVariable Integer affiliationId, @RequestBody Affiliation affiliation) {
        affiliation.setId(affiliationId);
        affiliationService.updateAffiliation(affiliation);
        return new ResponseEntity<>(affiliation, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{affiliationId}")
    public ResponseEntity<Integer> deleteAffiliation(@PathVariable Integer affiliationId) {
        affiliationService.deleteAffiliation(affiliationId);
        return new ResponseEntity<>(affiliationId, HttpStatus.OK);
    }

}
