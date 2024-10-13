package com.ytrewq.rosLearning.repositories.Impl;

import com.ytrewq.rosLearning.Entities.Course;
import com.ytrewq.rosLearning.repositories.BaseRepository;
import com.ytrewq.rosLearning.repositories.CourseRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository
public class CourseRepositoryImpl extends BaseRepository<Course,Integer> implements CourseRepository {
    @Autowired
    EntityManager entityManager;
    public CourseRepositoryImpl() {
        super(Course.class);
    }
    @Override
    public Course getCourseByTitle(String title) {
        String jpql="Select cs FROM Course cs WHERE cs.title = :title";
        return entityManager.createQuery(jpql, Course.class)
                .setParameter("title", title)
                .getSingleResult();
    }

    @Override
    public Set<Course> getAllUserCourses(int id) {
        String jpql="Select us.courses FROM User us WHERE us.id = :id";
        return new HashSet<>(entityManager.createQuery(jpql, Course.class)
                .setParameter("id", id)
                .getResultList());
    }
}
