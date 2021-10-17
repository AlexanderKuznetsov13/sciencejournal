package ru.agk13145.sciencejournal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.agk13145.sciencejournal.model.Config;
import ru.agk13145.sciencejournal.service.ConfigService;

import java.util.List;

@Controller
@RequestMapping(value = "/configs", produces = "application/json;charset=UTF-8")
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Config>> getConfigs() {
        List<Config> configs = configService.getConfigs();
        return new ResponseEntity<>(configs, HttpStatus.OK);
    }

    @GetMapping(value = "/{configId}")
    @ResponseBody
    public ResponseEntity<Config> getConfig(@PathVariable Integer configId) {
        Config config = configService.getConfig(configId);
        return new ResponseEntity<>(config, HttpStatus.OK);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Config> createConfig(@RequestBody Config config) {
        Integer configId = configService.createConfig(config);
        config = configService.getConfig(configId);
        return new ResponseEntity<>(config, HttpStatus.OK);
    }

    @PutMapping(value = "/{configId}")
    @ResponseBody
    public ResponseEntity<Config> updateConfig(@PathVariable Integer configId, @RequestBody Config config) {
        config.setId(configId);
        configService.updateConfig(config);
        return new ResponseEntity<>(config, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{configId}")
    public ResponseEntity<Integer> deleteConfig(@PathVariable Integer configId) {
        configService.deleteConfig(configId);
        return new ResponseEntity<>(configId, HttpStatus.OK);
    }

}
