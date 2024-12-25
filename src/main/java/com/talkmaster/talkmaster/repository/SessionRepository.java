package com.talkmaster.talkmaster.repository;

import com.talkmaster.talkmaster.model.Session;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends MongoRepository<Session, String> {
    // Find all sessions by instructorId
    List<Session> findByInstructorId(String instructorId);

    // Find all sessions by studentId
    List<Session> findByStudentId(String studentId);

    // Find all sessions by status (e.g., pending, confirmed, completed)
    List<Session> findByStatus(String status);

    // Find all sessions for a specific student and instructor
    List<Session> findByStudentIdAndInstructorId(String studentId, String instructorId);

    // Find all sessions by date range 
    List<Session> findBySessionDateBetween(String startDate, String endDate);
}
