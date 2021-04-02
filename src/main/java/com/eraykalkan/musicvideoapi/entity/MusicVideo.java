package com.eraykalkan.musicvideoapi.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "music_video")
public class MusicVideo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(name = "music_video_id", nullable = false, unique = true)
    private Integer musicVideoId;

    @Column(name = "title", length = 200, nullable = false)
    private String title;

    @Column(name = "album", length = 100)
    private String album;

    @Column(name = "artist", length = 200)
    private String artist;

    @ManyToOne
    private Genre genre;

    @ElementCollection
    @CollectionTable(name = "sub_genre")
    private Set<String> subGenres;

    @Column(name = "duration", length = 3)
    private Integer duration;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicVideo that = (MusicVideo) o;
        return Objects.equals(musicVideoId, that.musicVideoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(musicVideoId);
    }
}
