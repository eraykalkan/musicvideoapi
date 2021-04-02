package com.eraykalkan.musicvideoapi.service.interfaces;


import com.eraykalkan.musicvideoapi.entity.Genre;

public interface GenreService {

    Genre findGenreByName(String genreName);

}
