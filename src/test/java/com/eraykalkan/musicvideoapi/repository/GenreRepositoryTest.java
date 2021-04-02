package com.eraykalkan.musicvideoapi.repository;

import com.eraykalkan.musicvideoapi.entity.Genre;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository genreRepository;

    private Genre genre;

    @BeforeAll
    public void injectedComponentsAreNotNull() {
        assertThat(genreRepository).as("Genre repository should not be null").isNotNull();
    }

    @BeforeEach
    public void setup() {
        genre = new Genre();
        genre.setId(5L);
        genre.setGenreName("Folk");
    }

    @Test
    void shouldReturnGenreForValidGenreName() {
        genreRepository.save(genre);

        assertThat(genreRepository.findByGenreName("Folk").get().getGenreName()).isEqualTo(genre.getGenreName());

    }

}
