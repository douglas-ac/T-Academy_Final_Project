package com.br.shopcar.Controller.Images;

import com.br.shopcar.Model.Announcement.Images;
import com.br.shopcar.Repository.ImageRepository;
import com.br.shopcar.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/image")
public class ImageController {

    @Autowired
    ImageRepository repository;

    @PostMapping("/upload")
    public ResponseEntity<Long> uplaodImage(@RequestParam("image") MultipartFile file)
            throws IOException {

        System.out.println(file);
        Images image =
                repository.save(Images.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageService.compressImage(file.getBytes())).build());
        return ResponseEntity.status(HttpStatus.OK)
                .body(image.getId());
    }

    @GetMapping(path = {"/get/{id}"})
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {

        final Optional<Images> dbImage = repository.findById(id);

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(dbImage.get().getType()))
                .body(ImageService.decompressImage(dbImage.get().getImage()));
    }
}
