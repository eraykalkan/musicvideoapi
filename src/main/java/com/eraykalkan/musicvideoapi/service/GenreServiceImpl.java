package com.eraykalkan.musicvideoapi.service;

import com.eraykalkan.musicvideoapi.entity.Genre;
import com.eraykalkan.musicvideoapi.repository.GenreRepository;
import com.eraykalkan.musicvideoapi.service.interfaces.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public Genre findGenreByName(String genreName) {
        return genreRepository.findByGenreName(genreName).orElse(new Genre());
    }
}
