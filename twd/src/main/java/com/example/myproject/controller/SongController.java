package com.example.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.myproject.model.Song;
import com.example.myproject.repository.SongRepository;
import com.example.myproject.service.FileService;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
@CrossOrigin(origins = "*")
public class SongController {

    @Autowired
    private SongRepository repo;

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public Song upload(@RequestParam("file") MultipartFile file,
                       @RequestParam("title") String title,
                       @RequestParam("artist") String artist) throws Exception {

        String fileName = fileService.saveFile(file);

        Song song = new Song();
        song.setTitle(title);
        song.setArtist(artist);
        song.setFileName(fileName);

        return repo.save(song);
    }

    @GetMapping
    public List<Song> allSongs() {
        return repo.findAll();
    }

    @GetMapping("/stream/{id}")
    public ResponseEntity<Resource> streamSong(@PathVariable Long id) throws Exception {
        Song song = repo.findById(id).orElseThrow();

        Resource audio = fileService.load(song.getFileName());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "audio/mpeg")
                .body(audio);
    }
}

