package com.example.myproject.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

@Service
public class FileService {

    private final Path uploadDir = Paths.get("uploads");

    public FileService() throws IOException {
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
    }

    public String saveFile(MultipartFile file) throws IOException {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path target = uploadDir.resolve(fileName);

        // Overwrite old file if exists
        Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);

        return fileName;
    }

    public void deleteFile(String fileName) throws IOException {
        Files.deleteIfExists(uploadDir.resolve(fileName));
    }

    public Resource load(String fileName) throws Exception {
        Path file = uploadDir.resolve(fileName);
        return new UrlResource(file.toUri());
    }
}
