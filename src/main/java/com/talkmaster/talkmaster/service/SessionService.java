package com.talkmaster.talkmaster.service;

import com.talkmaster.talkmaster.model.Session;
import com.talkmaster.talkmaster.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    // Create a new session
    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    // Get all sessions
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    // Get session by ID
    public Optional<Session> getSessionById(String sessionId) {
        return sessionRepository.findById(sessionId);
    }

    // Get sessions by studentId, instructorId, and status
    public List<Session> getSessions(String studentId, String instructorId, String status) {
        if (studentId != null && instructorId != null && status != null) {
            return sessionRepository.findByStatusAndStudentIdAndInstructorId(status, studentId, instructorId);
        } else if (studentId != null && instructorId != null) {
            return sessionRepository.findByStudentIdAndInstructorId(studentId, instructorId);
        } else if (studentId != null && status != null) {
            return sessionRepository.findByStudentIdAndStatus(studentId, status);
        } else if (instructorId != null && status != null) {
            return sessionRepository.findByInstructorIdAndStatus(instructorId, status);
        } else if (studentId != null) {
            return sessionRepository.findByStudentId(studentId);
        } else if (instructorId != null) {
            return sessionRepository.findByInstructorId(instructorId);
        } else {
            return List.of();
        }
    }

    // Get sessions within a date range for a specific student or instructor
    public List<Session> getSessionsByDateRangeAndUser(String startDate, String endDate, String studentId,  String instructorId) {
        LocalDateTime startDateTime;
        LocalDateTime endDateTime;

        if (startDate == null || startDate.isEmpty()) {
            startDateTime = LocalDateTime.now();
        } else {
            startDateTime = LocalDateTime.parse(startDate);
        }

        if (endDate == null || endDate.isEmpty()) {
            endDateTime = LocalDateTime.now().plusDays(7);
        } else {
            endDateTime = LocalDateTime.parse(endDate);
        }

        if (studentId != null) {
            return sessionRepository.findByStudentIdAndStartTimeBetween(studentId, startDateTime, endDateTime);
        } else {
            return sessionRepository.findByInstructorIdAndStartTimeBetween(instructorId, startDateTime, endDateTime);
        }
    }

    // Update a session
    public Session updateSession(String sessionId, Session sessionDetails) {
        return sessionRepository.findById(sessionId).map(session -> {
            if(sessionDetails.getTopic() != null) {
                session.setTopic(sessionDetails.getTopic());
            }
            if(sessionDetails.getStartTime() != null) {
                session.setStartTime(sessionDetails.getStartTime());
            }
            if(sessionDetails.getEndTime() != null) {
                session.setEndTime(sessionDetails.getEndTime());
            }
            if(sessionDetails.getInstructorId() != null) {
                session.setInstructorId(sessionDetails.getInstructorId());
            }
            if(sessionDetails.getStudentId() != null) {
                session.setStudentId(sessionDetails.getStudentId());
            }
            if(sessionDetails.getStatus() != null) {
                session.setStatus(sessionDetails.getStatus());
            }
            return sessionRepository.save(session);
        }).orElseThrow(() -> new RuntimeException("Session not found with id: " + sessionId));
    }

    // Delete a session by ID
    public void deleteSession(String sessionId) {
        sessionRepository.deleteById(sessionId);
    }
}
