package com.docker.springboot_docker_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/docker")
public class DockerController {

    @GetMapping("/hellodocker")
    public String HelloDocker(){
        return "Hello Docker";
    }
}
