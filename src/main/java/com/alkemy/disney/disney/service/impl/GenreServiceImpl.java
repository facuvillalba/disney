package com.alkemy.disney.disney.service.impl;

import com.alkemy.disney.disney.dto.GenreDTO;
import com.alkemy.disney.disney.entity.GenreEntity;
import com.alkemy.disney.disney.mapper.GenreMapper;
import com.alkemy.disney.disney.repository.GenreRepository;
import com.alkemy.disney.disney.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreMapper genreMapper;

    @Autowired
    private GenreRepository genreRepository;

    //Service to save genre in Repository.
    public GenreDTO save(GenreDTO dto) {
        GenreEntity entity = genreMapper.genreDTO2Entity(dto);
        GenreEntity entitySaved = genreRepository.save(entity);
        GenreDTO result = genreMapper.genreEntity2DTO(entitySaved);
        return result;
    }

    //Service to get all genres in repository.
    public List<GenreDTO> getAllGenres() {
        List<GenreEntity> entities = genreRepository.findAll();
        List<GenreDTO> result = genreMapper.genreEntityList2DTOList(entities);
        return result;
    }

    //Service to softly delete genre in Repository.
    public void delete(Long id){
        genreRepository.deleteById(id);
    }
}
