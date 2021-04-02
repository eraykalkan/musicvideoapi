package com.eraykalkan.musicvideoapi.controller;

import com.eraykalkan.musicvideoapi.dto.MusicVideoDTO;
import com.eraykalkan.musicvideoapi.service.interfaces.MusicVideoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicvideos")
@Tag(name = "music videos", description = "Music Video MetaData Management API")
@RequiredArgsConstructor
public class MusicVideoController {

    private final MusicVideoService musicVideoService;

    @Operation(summary = "Lists available music videos", tags = "music video actions")
    @GetMapping
    public ResponseEntity<List<MusicVideoDTO>> getAll() {
        return new ResponseEntity<>(musicVideoService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Lists music video by music video id", tags = "music video actions")
    @GetMapping("/{musicVideoId}")
    public ResponseEntity<MusicVideoDTO> getMusicVideoByMusicVideoId(@PathVariable("musicVideoId") Integer musicVideoId) {
        return new ResponseEntity<>(musicVideoService.findByMusicVideoId(musicVideoId), HttpStatus.OK);
    }

    @Operation(summary = "Lists music video by music genre", tags = "music video actions")
    @GetMapping("/genre/{genreName}")
    public ResponseEntity<List<MusicVideoDTO>> getMusicVideoByGenre(@PathVariable("genreName") String genreName) {
        return new ResponseEntity<>(musicVideoService.findByGenreName(genreName), HttpStatus.OK);
    }

    @Operation(summary = "Lists music video by music sub genre", tags = "music video actions")
    @GetMapping("/subgenres/{subGenre}")
    public ResponseEntity<List<MusicVideoDTO>> getMusicVideoBySubGenres(@PathVariable("subGenre") String subGenre) {
        return new ResponseEntity<>(musicVideoService.findBySubGenre(subGenre), HttpStatus.OK);
    }

    @Operation(summary = "Creates a new Music video object in the API", tags = "music video actions")
    @PostMapping
    public ResponseEntity<MusicVideoDTO> saveMusicVideo(@RequestBody MusicVideoDTO musicVideoDTO) {
        return new ResponseEntity<>(musicVideoService.save(musicVideoDTO), HttpStatus.OK);
    }

    @Operation(summary = "Creates a new Music video object in the API by id", tags = "music video actions")
    @PostMapping("/{musicVideoId}")
    public ResponseEntity<MusicVideoDTO> saveMusicVideoWithId(@PathVariable("musicVideoId") Integer musicVideoId,
                                                              @RequestBody MusicVideoDTO musicVideoDTO) {
        musicVideoDTO.setMusicVideoId(musicVideoId);
        return new ResponseEntity<>(musicVideoService.save(musicVideoDTO), HttpStatus.OK);
    }

    @Operation(summary = "Updates a new Music video object in the API", tags = "music video actions")
    @PutMapping("/")
    public ResponseEntity<MusicVideoDTO> updateMusicVideo(@RequestBody MusicVideoDTO musicVideoDTO) {
        return new ResponseEntity<>(musicVideoService.update(musicVideoDTO), HttpStatus.OK);
    }

    @Operation(summary = "Updates a new Music video object in the API by id", tags = "music video actions")
    @PutMapping("/{musicVideoId}")
    public ResponseEntity<MusicVideoDTO> updateMusicVideoById(@PathVariable("musicVideoId") Integer musicVideoId,
                                                              @RequestBody MusicVideoDTO musicVideoDTO) {
        musicVideoDTO.setMusicVideoId(musicVideoId);
        return new ResponseEntity<>(musicVideoService.update(musicVideoDTO), HttpStatus.OK);
    }

    @Operation(summary = "Deletes a new Music video object in the API by id", tags = "music video actions")
    @DeleteMapping("/{musicVideoId}")
    public void deleteMusicVideoById(@PathVariable("musicVideoId") Integer musicVideoId) {
        musicVideoService.deleteByMusicVideoId(musicVideoId);
    }

}
