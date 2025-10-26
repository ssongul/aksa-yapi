package com.aksayapi.controller;

import com.aksayapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public String projects(Model model) {
        model.addAttribute("projects", projectService.getAllProjects());
        return "projects";
    }

    @GetMapping("/proje/alacati-marina")
    public String alacatiMarina(Model model) {
        return "project-alacati-marina";
    }
    @GetMapping("/proje/kiosk-otel")
    public String kioskOtel(Model model) {
        return "project-kiosk-otel";
    }
    @GetMapping("/proje/swiss-otel")
    public String swissOtel(Model model) {
        return "project-swiss-otel";
    }
    @GetMapping("/proje/invictus-port")
    public String invictusPort(Model model) {
        return "project-invictus-port";
    }
    @GetMapping("/proje/ciftlikkoy-villa")
    public String ciftlikkoyVilla(Model model) {
        return "project-ciftlikkoy-villa";
    }
    @GetMapping("/proje/ozgekent-evleri")
    public String ozgekentEvleri(Model model) {
        return "project-ozgekent-evleri";
    }
    @GetMapping("/proje/nohutalan-evi")
    public String nohutalanEvi(Model model) {
        return "project-nohutalan-evi";
    }
    @GetMapping("/proje/cesme-tadilat")
    public String cesmeTadilat(Model model) {
        return "project-cesme-tadilat";
    }
    @GetMapping("/proje/dalyan-villa1")
    public String dalyanVilla1(Model model) {
        return "project-dalyan-villa1";
    }
}
