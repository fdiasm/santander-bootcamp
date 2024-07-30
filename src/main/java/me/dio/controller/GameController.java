package me.dio.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.dio.domain.model.Game;
import me.dio.service.GameService;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> findById(@PathVariable("id") Long id) {
        var game = gameService.findById(id);
        return ResponseEntity.ok(game);
    }

    @PostMapping
    public ResponseEntity<Game> create(@RequestBody Game gameToCreate) {
        var gameCreated = gameService.create(gameToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(gameCreated.getId())
            .toUri();
        return ResponseEntity.created(location).body(gameCreated);
    }
}
