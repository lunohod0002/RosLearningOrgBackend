package com.ytrewq.rosLearning.Controllers;


import com.ytrewq.rosLearning.DTOs.CourseDto;
import com.ytrewq.rosLearning.Entities.User;
import com.ytrewq.rosLearning.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/user/getUserCourses")
    public CourseDto[] getUserCourses(@AuthenticationPrincipal User user) {
        return courseService.getAllUserCourses(user.getId());
    }

   @GetMapping("/admin/getAllCourses")
    public CourseDto[] getAllCourses() {
        return courseService.getAllCourses();

    }
    @GetMapping("/admin/getCourse/{course_id}")
    public CourseDto getCourse(@RequestParam int course_id) {
        return courseService.getCourseById(course_id);

    }


}
