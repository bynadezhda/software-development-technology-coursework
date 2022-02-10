package com.example.kursach.service;

import com.example.kursach.model.Image;

public interface ImageService {

    void save(Image image);

    Image getImageAuthUser();

    Image findByUserId(Long id);

    boolean existByUserId(Long id);

    boolean exist();

    void delete();
}
