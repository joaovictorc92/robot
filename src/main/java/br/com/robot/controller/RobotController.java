package br.com.robot.controller;

import br.com.robot.service.NavigateService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotController {

    private final NavigateService service;

    public RobotController(NavigateService service) {
        this.service = service;
    }

    @RequestMapping("/rest/mars/")
    public String position() {
        return "teste";
    }

    @PostMapping("/rest/mars/{command}")
    public ResponseEntity<String> navigate(@PathVariable("command") String command) {
        try {
            return ResponseEntity.ok(service.execute(command.split(Strings.EMPTY)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }
}
