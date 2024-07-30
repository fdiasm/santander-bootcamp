package me.dio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.domain.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}
