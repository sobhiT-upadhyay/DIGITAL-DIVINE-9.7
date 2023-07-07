package com.booking.service;

import com.booking.entities.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> getAllFeedbacks();
    Feedback getFeedbackById(Long id);
    Feedback createFeedback(Feedback feedback);
    void updateFeedback(Long id, Feedback feedback);
    void deleteFeedback(Long id);
}
