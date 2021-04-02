package com.eraykalkan.musicvideoapi.repository;

import com.eraykalkan.musicvideoapi.entity.MusicVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MusicVideoRepository extends JpaRepository<MusicVideo, Long> {

    Optional<MusicVideo> findByMusicVideoId(Integer musicVideoId);

    List<MusicVideo> findByGenreGenreName(String genreName);

    List<MusicVideo> findBySubGenresIn(String... subGenre);

    void deleteByMusicVideoId(Integer musicVideoId);


}
