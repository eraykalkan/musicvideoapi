package com.eraykalkan.musicvideoapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class MusicVideoDTO {

    private static final long serialVersionUID = -5220522330517813870L;

    private Integer musicVideoId;

    private String title;

    private String album;

    private String artist;

    private Integer duration;

    private String genre;

    private Set<String> subGenres;

    private Integer releaseYear;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MusicVideoDTO that = (MusicVideoDTO) o;
        return Objects.equals(musicVideoId, that.musicVideoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), musicVideoId);
    }
}
