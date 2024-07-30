package me.dio.service;

import me.dio.domain.model.Game;

public interface GameService {

    Game findById(Long id);

    Game create(Game gameToCreate);
}
