package com.talkmaster.talkmaster.service;

import com.talkmaster.talkmaster.model.Session;
import com.talkmaster.talkmaster.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    // Get all sessions
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    // Get session by ID
    public Optional<Session> getSessionById(String sessionId) {
        return sessionRepository.findById(sessionId);
    }

    // Get sessions by instructor ID
    public List<Session> getSessionsByInstructorId(String instructorId) {
        return sessionRepository.findByInstructorId(instructorId);
    }

    // Get sessions by student ID
    public List<Session> getSessionsByStudentId(String studentId) {
        return sessionRepository.findByStudentId(studentId);
    }

    // Get sessions by status
    public List<Session> getSessionsByStatus(String status) {
        return sessionRepository.findByStatus(status);
    }

    // Get sessions by student and instructor
    public List<Session> getSessionsByStudentAndInstructor(String studentId, String instructorId) {
        return sessionRepository.findByStudentIdAndInstructorId(studentId, instructorId);
    }

    // Get sessions within a date range
    public List<Session> getSessionsByDateRange(String startDate, String endDate) {
        return sessionRepository.findBySessionDateBetween(startDate, endDate);
    }

    // Create a new session
    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    // Update a session
    public Session updateSession(String sessionId, Session sessionDetails) {
        return sessionRepository.findById(sessionId).map(session -> {
            session.setStartTime(sessionDetails.getStartTime());
            session.setEndTime(sessionDetails.getEndTime());
            session.setInstructorId(sessionDetails.getInstructorId());
            session.setStudentId(sessionDetails.getStudentId());
            session.setStatus(sessionDetails.getStatus());
            return sessionRepository.save(session);
        }).orElseThrow(() -> new RuntimeException("Session not found with id: " + sessionId));
    }

    // Delete a session by ID
    public void deleteSession(String sessionId) {
        sessionRepository.deleteById(sessionId);
    }
}
