package me.dio.service;

import me.dio.domain.model.Review;

public interface ReviewService {

    Review findById(Long id);

    Review create(Review reviewToCreate);
}
