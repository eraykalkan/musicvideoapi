package com.eraykalkan.musicvideoapi.service;


import com.eraykalkan.musicvideoapi.dto.MusicVideoDTO;
import com.eraykalkan.musicvideoapi.entity.Genre;
import com.eraykalkan.musicvideoapi.entity.MusicVideo;
import com.eraykalkan.musicvideoapi.exception.GenreException;
import com.eraykalkan.musicvideoapi.exception.MusicVideoException;
import com.eraykalkan.musicvideoapi.mapper.MusicVideoMapper;
import com.eraykalkan.musicvideoapi.repository.MusicVideoRepository;
import com.eraykalkan.musicvideoapi.service.interfaces.GenreService;
import com.eraykalkan.musicvideoapi.service.interfaces.MusicVideoService;
import com.eraykalkan.musicvideoapi.util.ExceptionMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class MusicVideoServiceImpl implements MusicVideoService {

    private final MusicVideoRepository musicVideoRepository;
    private final GenreService genreService;
    private final MusicVideoMapper musicVideoMapper;

    @Transactional
    @Override
    public MusicVideoDTO save(MusicVideoDTO musicVideoDTO) {

        if (isMusicVideoExistsByMusicVideoId(musicVideoDTO.getMusicVideoId())) {
            throw new MusicVideoException(ExceptionMessage.MUSICVIDEO_ALREADY_EXISTS);
        }

        validateMetaData(musicVideoDTO);

        MusicVideo musicVideo = musicVideoMapper.toEntity(musicVideoDTO);
        Genre genre = genreService.findGenreByName(musicVideoDTO.getGenre());
        musicVideo.setGenre(genre);


        return musicVideoMapper.toDto(musicVideoRepository.save(musicVideo));

    }

    @Override
    @Transactional
    public MusicVideoDTO update(MusicVideoDTO musicVideoDTO) {

        validateMetaData(musicVideoDTO);

        MusicVideo musicVideo = musicVideoRepository.findByMusicVideoId(musicVideoDTO.getMusicVideoId())
                .orElseThrow(() -> new MusicVideoException(ExceptionMessage.MUSICVIDEO_NOT_FOUND));

        MusicVideo updateMusicVideo = musicVideoMapper.toEntity(musicVideoDTO);
        updateMusicVideo.setId(musicVideo.getId());

        Genre genre = genreService.findGenreByName(musicVideoDTO.getGenre());
        updateMusicVideo.setGenre(genre);

        BeanUtils.copyProperties(updateMusicVideo, musicVideo);

        return musicVideoMapper.toDto(musicVideoRepository.save(musicVideo));
    }

    @Override
    public List<MusicVideoDTO> findAll() {
        List<MusicVideo> musicVideos = musicVideoRepository.findAll();
        if (!musicVideos.isEmpty()) {
            return musicVideos
                    .stream()
                    .map(musicVideoMapper::toDto)
                    .collect(Collectors.toList());
        } else {
            throw new MusicVideoException(ExceptionMessage.MUSICVIDEOS_NOT_FOUND);
        }
    }

    @Override
    public MusicVideoDTO findByMusicVideoId(Integer musicVideoId) {
        MusicVideo musicVideo = musicVideoRepository.findByMusicVideoId(musicVideoId)
                .orElseThrow(() -> new MusicVideoException(ExceptionMessage.MUSICVIDEO_NOT_FOUND));
        return musicVideoMapper.toDto(musicVideo);
    }

    @Override
    public List<MusicVideoDTO> findByGenreName(String genreName) {
        List<MusicVideo> musicVideos = musicVideoRepository.findByGenreGenreName(genreName);
        if (!musicVideos.isEmpty()) {
            return musicVideos
                    .stream()
                    .map(musicVideoMapper::toDto)
                    .collect(Collectors.toList());
        } else {
            throw new MusicVideoException(ExceptionMessage.MUSICVIDEOS_NOT_FOUND);
        }
    }

    @Override
    public List<MusicVideoDTO> findBySubGenre(String subGenreName) {
        List<MusicVideo> musicVideos = musicVideoRepository.findBySubGenresIn(subGenreName);
        if (!musicVideos.isEmpty()) {
            return musicVideos
                    .stream()
                    .map(musicVideoMapper::toDto)
                    .collect(Collectors.toList());
        } else {
            throw new MusicVideoException(ExceptionMessage.MUSICVIDEOS_NOT_FOUND);
        }
    }

    @Override
    @Transactional
    public void deleteByMusicVideoId(Integer musicVideoId) {
        musicVideoRepository.deleteByMusicVideoId(musicVideoId);
    }

    @Override
    public void validateMetaData(MusicVideoDTO musicVideoDTO) {
        if (musicVideoDTO.getGenre() != null &&
                !isGenreNameValid(musicVideoDTO.getGenre())) {
            throw new GenreException(ExceptionMessage.GENRE_NOT_FOUND + ": " + musicVideoDTO.getGenre());
        }
        if (musicVideoDTO.getReleaseYear() != null &&
                !isReleaseYearValid(musicVideoDTO.getReleaseYear())) {
            throw new MusicVideoException(ExceptionMessage.MUSICVIDEO_RELEASE_DATE_INVALID);
        }
    }

    @Override
    public boolean isMusicVideoExistsByMusicVideoId(Integer musicVideoId) {
        return musicVideoRepository.findByMusicVideoId(musicVideoId).isPresent();
    }

    // The Little Lost Child - 1894 - first known illustrated song
    @Override
    public boolean isReleaseYearValid(Integer year) {
        return (year >= 1894 && year <= Year.now().getValue());
    }

    @Override
    public boolean isGenreNameValid(String genreName) {
        return genreService.findGenreByName(genreName).getGenreName() != null;
    }


}
