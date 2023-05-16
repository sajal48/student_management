package com.sajal.student_management.service;

import com.sajal.student_management.dto.CourseDto;
import com.sajal.student_management.exception.ResourceNotFoundException;
import com.sajal.student_management.model.Course;
import com.sajal.student_management.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course addCourse(CourseDto courseDto) throws ResourceNotFoundException {
        if(courseExist(courseDto.getCourseId())){
            throw  new ResourceNotFoundException("Course  with same ID Already exist");
        }
        else{
            Course course = Course.builder()
                    .courseId(courseDto.getCourseId())
                    .courseName(courseDto.getCourseName())
                    .courseDescription(courseDto.getCourseDescription())
                    .build();
           return courseRepository.save(course);
        }
    }

    @Override
    public void deleteCourseById(String courseId) throws ResourceNotFoundException {
        if(!courseExist(courseId)){
            throw  new ResourceNotFoundException("No course found with matching Id");
        }
        courseRepository.deleteById(courseId);
    }

    @Override
    public Course editCourse(CourseDto courseDto) throws ResourceNotFoundException {

        Course courseFromDb = getCourseById(courseDto.getCourseId());
        courseFromDb.setCourseName(courseDto.getCourseName());
        courseFromDb.setCourseDescription(courseDto.getCourseDescription());
        return courseRepository.save(courseFromDb);
    }

    @Override
    public Course getCourseById(String courseId) throws ResourceNotFoundException {
        if(!courseExist(courseId)){
            throw  new ResourceNotFoundException("No course found with matching Id");
        }
        return courseRepository.findById(courseId).get();
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    private boolean courseExist(String courseId)  {
        if(!courseRepository.existsById(courseId)){
            return false;
        }
        return  true;
    }

}
