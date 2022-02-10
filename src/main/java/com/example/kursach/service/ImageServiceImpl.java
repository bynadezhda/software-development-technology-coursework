package com.example.kursach.service;

import com.example.kursach.model.Image;
import com.example.kursach.repository.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {
    private ImageRepository imageRepository;

    @Override
    @Transactional
    public void save(Image image) {
        if (imageRepository.existsByUserLogin(SecurityContextHolder.getContext().getAuthentication().getName())) {
            Image image1 = imageRepository.findAllByUserLogin(SecurityContextHolder.getContext().getAuthentication().getName());
            image.setId(image1.getId());
        }
        imageRepository.save(image);
    }

    @Override
    @Transactional
    public Image getImageAuthUser() {
        return imageRepository.findAllByUserLogin(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @Override
    @Transactional
    public Image findByUserId(Long id) {
        return imageRepository.findByUserId(id);
    }

    @Override
    @Transactional
    public boolean existByUserId(Long id) {
        return imageRepository.existsByUserId(id);
    }

    @Override
    public boolean exist() {
        return imageRepository.existsByUserLogin(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @Override
    @Transactional
    public void delete() {
        imageRepository.deleteByUserLogin(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
