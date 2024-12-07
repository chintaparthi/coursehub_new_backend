package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class coursedao {

    @Autowired
    CourseInterface repo;

    public void add(Courses c) {
        repo.save(c);
    }

    public List<Courses> get() {
        return repo.findAll();
    }

    public void delete(String coursecode) {
        Courses c = repo.findByCoursecode(coursecode);
        repo.delete(c);
    }

    public void edit(Courses c) {
        delete(c.getCoursecode());
        repo.save(c);
    }

    public Courses findByCoursecode(String coursecode) {
        return repo.findByCoursecode(coursecode);
    }
}
