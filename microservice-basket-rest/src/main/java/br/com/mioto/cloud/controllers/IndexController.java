package br.com.mioto.cloud.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/home")
    @ResponseBody
    public String home() {
    	
    	log.info("Fare Rest Service >> Alive!");
        return "Fare Rest Service, I'm Alive";
    }
}