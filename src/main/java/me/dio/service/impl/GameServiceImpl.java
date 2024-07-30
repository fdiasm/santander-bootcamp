package me.dio.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.domain.model.Game;
import me.dio.domain.repository.GameRepository;
import me.dio.service.GameService;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game findById(Long id) {
        return gameRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Game create(Game gameToCreate) {
        if (gameRepository.existsById(gameToCreate.getId())) {
            throw new IllegalArgumentException("This id already exists.");
        }

        return gameRepository.save(gameToCreate);
    }
}
