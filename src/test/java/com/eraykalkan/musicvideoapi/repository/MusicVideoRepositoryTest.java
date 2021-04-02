package com.eraykalkan.musicvideoapi.repository;

import com.eraykalkan.musicvideoapi.entity.Genre;
import com.eraykalkan.musicvideoapi.entity.MusicVideo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MusicVideoRepositoryTest {

    @Autowired
    private MusicVideoRepository musicVideoRepository;

    private MusicVideo musicVideo;

    @BeforeAll
    public void injectedComponentsAreNotNull() {
        assertThat(musicVideoRepository).as("MusicVideo repository should not be null").isNotNull();
    }

    @BeforeEach
    public void setup() {
        musicVideo = new MusicVideo();

        Genre genre = new Genre();
        genre.setId(5L);

        musicVideo.setId(1L);
        musicVideo.setMusicVideoId(1345);
        musicVideo.setGenre(genre);
        musicVideo.setAlbum("Epic Album");
        musicVideo.setArtist("Best Artist Ever");
        musicVideo.setDuration(150);
        musicVideo.setReleaseYear(1999);
        musicVideo.setTitle("World's most famous music video");
        musicVideo.setSubGenres(Set.of("Rock","Classical"));

    }

    @Test
    void findByMusicVideoIdShouldReturnValidMusicVideo() {
        musicVideoRepository.save(musicVideo);

        assertThat(musicVideoRepository.findByMusicVideoId(1345).get()).isEqualTo(musicVideo);

    }

    @Test
    void findByGenreNameShouldReturnListOfMusicVideos() {
        musicVideoRepository.save(musicVideo);

        assertThat(musicVideoRepository.findByGenreGenreName("Folk")).isNotEmpty();

    }

    @Test
    void findBySubGenresShouldReturnListOfMusicVideos() {
        musicVideoRepository.save(musicVideo);

        assertThat(musicVideoRepository.findBySubGenresIn("Classical")).isNotEmpty();

    }

}
