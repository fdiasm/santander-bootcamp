package me.dio.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.dio.domain.model.Review;
import me.dio.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> findById(@PathVariable("id") Long id) {
        var review = reviewService.findById(id);
        return ResponseEntity.ok(review);
    }

    @PostMapping
    public ResponseEntity<Review> create(@RequestBody Review reviewToCreate) {
        var reviewCreated = reviewService.create(reviewToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(reviewCreated.getId())
            .toUri();
        return ResponseEntity.created(location).body(reviewCreated);
    }
}
