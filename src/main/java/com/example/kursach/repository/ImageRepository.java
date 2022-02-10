package com.example.kursach.repository;

import com.example.kursach.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    Image findByUserId(Long id);

    Image findAllByUserLogin(String login);

    boolean existsByUserLogin(String login);

    boolean existsByUserId(Long id);

    void deleteByUserLogin(String login);
}
