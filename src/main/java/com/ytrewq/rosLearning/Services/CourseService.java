package com.ytrewq.rosLearning.Services;

import com.ytrewq.rosLearning.DTOs.CourseDto;
import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.Repositories.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    UserService userService;

    ModelMapper modelMapper = new ModelMapper();

    public List<CourseDto> getUserCourses(User currentUser) {
        List<Course> courses = userService.getUserCourses(currentUser);
        return courses.stream().map(course -> modelMapper.map(course, CourseDto.class)).toList();
    }

    public List<CourseDto> getAllCourses() {
        Set<Course> courses = courseRepository.findAll();
        return courses.stream().map(course -> modelMapper.map(course, CourseDto.class)).toList();

    }

//    public Course getUserCourseById(User currentUser, int courseId) {
//        Course[] courses = currentUser.getCourses();
//        for (Course course : courses) {
//            if (course.getId() == courseId) {
//                return course;
//            }
//        }
//        return null;
//    }


//
//    public void saveCourse(CourseDto courseDto) {
//        String description = courseDto.getDescription();
//        String title = courseDto.getTitle();
//        LocalDateTime date_of_creation = LocalDateTime.now();
//        Course course = new Course(title, date_of_creation, description, null);
//        courseRepository.save(course);
//    }
//
//
//    public CourseDto getCourseById(int id) {
//        if (courseRepository.findById(id).isPresent()){
//            return modelMapper.map(courseRepository.findById(id),CourseDto.class);
//        }
//
//
//    }
}
