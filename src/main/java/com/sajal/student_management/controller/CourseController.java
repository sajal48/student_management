package com.sajal.student_management.controller;

import com.sajal.student_management.dto.CourseDto;
import com.sajal.student_management.exception.ResourceNotFoundException;
import com.sajal.student_management.model.Course;
import com.sajal.student_management.repository.CourseRepository;
import com.sajal.student_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @PostMapping("/add")
    public ResponseEntity<Object> addCourse(@RequestBody CourseDto courseDto) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(courseService.addCourse(courseDto));
    }

    @DeleteMapping("/")
    public ResponseEntity<Object> deleteCourse(@RequestParam String courseId) throws ResourceNotFoundException {
        courseService.deleteCourseById(courseId);
        return ResponseEntity.ok("Course Deleted");
    }

    @PutMapping("/")
    public ResponseEntity<Object> editCourse(@RequestBody CourseDto courseDto) throws ResourceNotFoundException {

        return ResponseEntity.ok().body(courseService.editCourse(courseDto));
    }

    @PostMapping("/")
    public ResponseEntity<Object> getCourseById(@RequestParam String courseId) throws ResourceNotFoundException {
        return ResponseEntity.ok(courseService.getCourseById(courseId));
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllCourses(){
        return ResponseEntity.ok(courseService.getAllCourses());
    }
}
