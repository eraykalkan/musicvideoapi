package com.eraykalkan.musicvideoapi.service.interfaces;


import com.eraykalkan.musicvideoapi.dto.MusicVideoDTO;

import java.util.List;

public interface MusicVideoService {

    MusicVideoDTO save(MusicVideoDTO musicVideoDTO);

    MusicVideoDTO update(MusicVideoDTO musicVideoDTO);

    MusicVideoDTO findByMusicVideoId(Integer musicVideoId);

    List<MusicVideoDTO> findAll();

    List<MusicVideoDTO> findByGenreName(String genreName);

    List<MusicVideoDTO> findBySubGenre(String subGenreName);

    void deleteByMusicVideoId(Integer musicVideoId);

    void validateMetaData(MusicVideoDTO musicVideoDTO);

    boolean isMusicVideoExistsByMusicVideoId(Integer musicVideoId);

    boolean isReleaseYearValid(Integer year);

    boolean isGenreNameValid(String genreName);

}
