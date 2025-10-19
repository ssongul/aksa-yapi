package com.aksayapi.controller;

import com.aksayapi.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/services")
    public String services(Model model) {
        model.addAttribute("services", serviceService.getAllServices());
        return "services";
    }
}
