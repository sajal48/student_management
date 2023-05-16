package com.sajal.student_management.service;

import com.sajal.student_management.dto.CourseDto;
import com.sajal.student_management.exception.ResourceNotFoundException;
import com.sajal.student_management.model.Course;

import java.lang.module.ResolutionException;
import java.util.List;

public interface CourseService {
    public Course addCourse(CourseDto courseDto) throws ResourceNotFoundException;
    public void deleteCourseById(String courseId) throws ResourceNotFoundException;
    public Course editCourse(CourseDto courseDto) throws ResourceNotFoundException;
    public Course getCourseById(String courseId) throws ResourceNotFoundException;
    public List<Course> getAllCourses();
}
