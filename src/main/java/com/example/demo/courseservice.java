package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class courseservice {

    @Autowired
    coursedao dao;

    @PostMapping(value = "/addcourse", consumes = "multipart/form-data")
    public String addcourse(
        @RequestParam("coursename") String coursename,
        @RequestParam("coursecode") String coursecode,
        @RequestParam(value = "pdfFile", required = false) MultipartFile pdfFile,
        @RequestParam(value = "imageFile", required = false) MultipartFile imageFile
    ) {
        try {
            Courses course = new Courses();
            course.setCoursename(coursename);
            course.setCoursecode(coursecode);

            if (pdfFile != null) {
                course.setPdfFile(pdfFile.getBytes());
            }

            if (imageFile != null) {
                course.setImageFile(imageFile.getBytes());
            }

            dao.add(course);
            return "Course added successfully.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to add course.";
        }
    }

    @GetMapping("/allcourses")
    public List<Courses> getallcourses() {
        return dao.get();
    }

    @DeleteMapping("/deleteCourse")
    public String deletecourse(@RequestParam("coursecode") String coursecode) {
        dao.delete(coursecode);
        return "Deleted successfully";
    }

    @PutMapping("/updateCourse")
    public String editcourse(@RequestBody Courses c) {
        dao.edit(c);
        return "Edited successfully";
    }

    @GetMapping("/findcourse")
    public Courses getcoursebyid(@RequestParam("coursecode") String coursecode) {
        return dao.findByCoursecode(coursecode);
    }
}
