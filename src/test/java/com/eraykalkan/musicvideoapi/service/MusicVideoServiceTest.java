package com.eraykalkan.musicvideoapi.service;

import com.eraykalkan.musicvideoapi.dto.MusicVideoDTO;
import com.eraykalkan.musicvideoapi.entity.Genre;
import com.eraykalkan.musicvideoapi.entity.MusicVideo;
import com.eraykalkan.musicvideoapi.mapper.MusicVideoMapper;
import com.eraykalkan.musicvideoapi.repository.GenreRepository;
import com.eraykalkan.musicvideoapi.repository.MusicVideoRepository;
import com.eraykalkan.musicvideoapi.service.interfaces.GenreService;
import com.eraykalkan.musicvideoapi.service.interfaces.MusicVideoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
public class MusicVideoServiceTest {

    @Mock
    private MusicVideoRepository musicVideoRepository;

    @Mock
    private GenreService genreService;

    @Mock
    private MusicVideoMapper musicVideoMapper;

    @InjectMocks
    private MusicVideoServiceImpl musicVideoService;

    @Mock
    private GenreRepository genreRepository;

    @InjectMocks
    private GenreServiceImpl genreServiceImpl;

    private MusicVideoDTO musicVideo;
    private Genre genre;

    @BeforeEach
    void setup() {

        genre = new Genre();
        genre.setId(5L);
        genre.setGenreName("Folk");

        musicVideo = new MusicVideoDTO();


        musicVideo.setMusicVideoId(1345);
        musicVideo.setGenre("Folk");
        musicVideo.setAlbum("Epic Album");
        musicVideo.setArtist("Best Artist Ever");
        musicVideo.setDuration(150);
        musicVideo.setReleaseYear(1999);
        musicVideo.setTitle("World's most famous music video");
        musicVideo.setSubGenres(Set.of("Rock","Classical"));

    }

    @Test
    void isReleaseYearValidShouldReturnTrueForValidYear() {
        assertThat(musicVideoService.isReleaseYearValid(2010)).isTrue();
    }

    @Test
    void isGenreNameValidShouldReturnGenreForValidName() {

    }
}
