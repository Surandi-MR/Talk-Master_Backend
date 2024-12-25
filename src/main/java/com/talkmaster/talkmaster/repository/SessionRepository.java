package com.talkmaster.talkmaster.repository;

import com.talkmaster.talkmaster.model.Session;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.time.LocalDateTime;

@Repository
public interface SessionRepository extends MongoRepository<Session, String> {
    // Find all sessions by instructorId
    List<Session> findByInstructorId(String instructorId);

    // Find all sessions by studentId
    List<Session> findByStudentId(String studentId);

    // Find all sessions by studentId and status
    List<Session> findByStudentIdAndStatus(String studentId, String status);

    // Find all sessions by instructorId and status
    List<Session> findByInstructorIdAndStatus(String instructorId, String status);

    // Find all sessions for a specific student and instructor
    List<Session> findByStudentIdAndInstructorId(String studentId, String instructorId);

    // Find all sessions by status and specific student and instructor
    List<Session> findByStatusAndStudentIdAndInstructorId(String status, String studentId, String instructorId);

    // Find all sessions by studentId and date range
    List<Session> findByStudentIdAndStartTimeBetween(String studentId, LocalDateTime startTime, LocalDateTime endTime);

    // Find all sessions by instructorId and date range
    List<Session> findByInstructorIdAndStartTimeBetween(String instructorId, LocalDateTime startTime, LocalDateTime endTime);
}
