package com.example.kursach.repository;

import com.example.kursach.model.Resume;
import com.example.kursach.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
    Resume findByUserId(Long id);

    Resume findByUserLogin(String login);

    boolean existsByUserLogin(String login);

    List<Resume> findAllByVisibility(Boolean visibility);

    void deleteByUserLogin(String login);

}
