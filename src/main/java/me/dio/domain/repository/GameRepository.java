package me.dio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.domain.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    
}
