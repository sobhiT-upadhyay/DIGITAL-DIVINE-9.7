package com.booking.service.impl;

import com.booking.entities.Feedback;


import com.booking.repository.FeedbackRepository;
import com.booking.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback not found with id: " + id));
    }

    @Override
    public Feedback createFeedback(Feedback feedback) {
        feedback.setCreatedAt(new Date());
        return feedbackRepository.save(feedback);
    }

    @Override
    public void updateFeedback(Long id, Feedback updatedFeedback) {
        Feedback feedback = getFeedbackById(id);
        feedback.setRating(updatedFeedback.getRating());
        feedback.setComments(updatedFeedback.getComments());
        feedback.setUpdatedAt(new Date());
        feedbackRepository.save(feedback);
    }

    @Override
    public void deleteFeedback(Long id) {
        Feedback feedback = getFeedbackById(id);
        feedbackRepository.delete(feedback);
    }
}
