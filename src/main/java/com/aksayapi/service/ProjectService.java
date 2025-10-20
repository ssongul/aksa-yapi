package com.aksayapi.service;

import com.aksayapi.entity.Project;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final List<Project> projects;

    public ProjectService() {
        this.projects = new ArrayList<>();
        initializeStaticData();
    }

    private void initializeStaticData() {
        projects.add(new Project(1L, "Alaçatı Marina", 
            "Alaçatı Marina projesi, modern marina tesisleri ve yat limanı içeren kapsamlı bir projedir.", 
            "/images/AlacatiMarina/Marina2.jpeg"));
        
        projects.add(new Project(2L, "Kiosk Otel", 
            "Kiosk Otel projesi, lüks konaklama tesisleri ve modern otel hizmetleri sunan bir projedir.", 
            "/images/KioskOtel/KioskOtel.jpeg"));
        
        projects.add(new Project(3L, "Swiss Otel", 
            "Swiss Otel projesi, uluslararası standartlarda konaklama ve hizmet kalitesi sunan bir projedir.", 
            "/images/SwissOtel/SwissOtel.jpeg"));
        
        projects.add(new Project(4L, "Invictus İnşaat Port", 
            "Invictus İnşaat Port projesi, modern liman tesisleri ve denizcilik altyapısı içeren bir projedir.", 
            "/images/InvictusInsaatPort/invictus1.jpeg"));
    }

    public List<Project> getAllProjects() {
        return new ArrayList<>(projects);
    }

    public Project getProjectById(Long id) {
        Optional<Project> project = projects.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst();
        return project.orElse(null);
    }

    public Project saveProject(Project project) {
        if (project.getId() == null) {
            Long maxId = projects.stream()
                .mapToLong(Project::getId)
                .max()
                .orElse(0L);
            project.setId(maxId + 1);
        }
        projects.add(project);
        return project;
    }

    public void deleteProject(Long id) {
        projects.removeIf(project -> project.getId().equals(id));
    }
}
