package com.example.kursach.controller;

import com.example.kursach.model.Image;
import com.example.kursach.repository.ImageRepository;
import com.example.kursach.service.ImageService;
import com.example.kursach.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(value = "/image")
@AllArgsConstructor
public class ImageRestController {

    private ImageService imageService;
    private ImageRepository imageRepository;
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> uploadImage(@RequestParam MultipartFile multipartImage) throws Exception {
        Image image = new Image();
        image.setName(multipartImage.getName());
        image.setContent(multipartImage.getBytes());
        image.setUser(userService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));

        imageService.save(image);

        return ResponseEntity.ok().build();
    }

    @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<?> downloadImage() {
        if (!imageService.exist()) {
            return ResponseEntity.status(404).body("Фотография не найдена");
        }
        byte[] image = imageService.getImageAuthUser().getContent();
        return ResponseEntity.ok(new ByteArrayResource(image));
    }

    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<?> findImage(@PathVariable Long id) {

        if (!imageService.existByUserId(id)) {
            return ResponseEntity.status(404).body("Фотография не найдена");
        }
        byte[] image = imageService.findByUserId(id).getContent();
        return ResponseEntity.ok(new ByteArrayResource(image));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(){
        imageService.delete();
        return ResponseEntity.ok().build();
    }
}
