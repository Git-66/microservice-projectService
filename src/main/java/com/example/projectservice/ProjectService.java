package com.example.projectservice;

//import com.example.projectservice.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectDao projectDao;

    public List<Project> getAllProjects() {
        return projectDao.findAll();
    }

    public Optional<Project> getProjectById(int id) {
        return projectDao.findById(id);
    }

    public void addProject(Project project) {
        projectDao.save(project);
    }

    public Optional<Project> updateProject(Project project, Integer id) {
        Optional<Project> existProject = projectDao.findById(id);
        if (existProject.isPresent()) {
            project.setId(id);
            projectDao.save(project);
        }
        return existProject;
    }

    public Optional<Project> deleteProjectById(int id) {
        Optional<Project> existProject = projectDao.findById(id);
        if (existProject.isPresent()) {
            projectDao.deleteById(id);
        }
        return existProject;
    }

    public void deleteAllProjects() {
        projectDao.deleteAll();
    }

}
