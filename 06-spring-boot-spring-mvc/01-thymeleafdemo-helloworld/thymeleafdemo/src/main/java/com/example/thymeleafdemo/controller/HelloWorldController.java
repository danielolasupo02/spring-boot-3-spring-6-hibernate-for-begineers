package com.example.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    // need a controller method to show initial form
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // need a controller method to read form data and
   // add data to the model

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {

        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        System.out.println(theName);

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo! " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }



    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model){
        // convert the data to all caps
        theName = theName.toUpperCase();

        // Your controller logic
        String yourVariable = "My name is "+ theName;
        logger.info("Your variable value: {}", yourVariable);


        // create the message
        String result = "Hey my friend from V3! " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

}
