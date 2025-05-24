package com.list.games.services;

import com.list.games.DTOs.GameListDTO;
import com.list.games.DTOs.GameMinDTO;
import com.list.games.entities.Game;
import com.list.games.entities.GameList;
import com.list.games.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

}
