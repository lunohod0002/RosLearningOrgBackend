package com.ytrewq.rosLearning.repositories.Impl;

import com.ytrewq.rosLearning.entities.Course;
import com.ytrewq.rosLearning.entities.Theme;
import com.ytrewq.rosLearning.entities.ThemeMaterial;
import com.ytrewq.rosLearning.repositories.BaseRepository;
import com.ytrewq.rosLearning.repositories.ThemeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ThemeRepositoryImpl extends BaseRepository<Theme, Integer> implements ThemeRepository {
    @PersistenceContext
    EntityManager entityManager;

    public ThemeRepositoryImpl() {
        super(Theme.class);
    }


    @Override
    public Set<Theme> getAllCourseThemes(Course course) {
        String jpql = "Select cs.themes FROM Course cs WHERE cs = :course";
        return new HashSet<>(entityManager.createQuery(jpql, Theme.class)
                .setParameter("cs", course)
                .getResultList());
    }

}
