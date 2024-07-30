package me.dio.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.domain.model.Review;
import me.dio.domain.repository.ReviewRepository;
import me.dio.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Review create(Review reviewToCreate) {
        if (reviewRepository.existsById(reviewToCreate.getId())) {
            throw new IllegalArgumentException("This id already exists.");
        }

        return reviewRepository.save(reviewToCreate);
    }
    
}
