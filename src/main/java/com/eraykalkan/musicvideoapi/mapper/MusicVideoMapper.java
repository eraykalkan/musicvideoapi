package com.eraykalkan.musicvideoapi.mapper;

import com.eraykalkan.musicvideoapi.dto.MusicVideoDTO;
import com.eraykalkan.musicvideoapi.entity.MusicVideo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MusicVideoMapper {

    @Mappings({
            @Mapping(target = "genre.genreName", source = "musicVideoDTO.genre")
    })
    MusicVideo toEntity(MusicVideoDTO musicVideoDTO);

    @Mappings({
            @Mapping(target = "genre", source = "musicVideo.genre.genreName")
    })
    MusicVideoDTO toDto(MusicVideo musicVideo);

}
