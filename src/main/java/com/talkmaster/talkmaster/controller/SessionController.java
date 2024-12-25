package com.talkmaster.talkmaster.controller;

import com.talkmaster.talkmaster.model.Session;
import com.talkmaster.talkmaster.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    
    // Create a new session
    @PostMapping
    public Session createSession(@RequestBody Session session) {
        return sessionService.createSession(session);
    }

    // Get all sessions
    @GetMapping("/all")
    public List<Session> getAllSessions() {
        return sessionService.getAllSessions();
    }

    // Get session by ID
    @GetMapping("/{id}")
    public Optional<Session> getSessionById(@PathVariable String id) {
        return sessionService.getSessionById(id);
    }

    // Get sessions by status and student and instructor
    @GetMapping
    public List<Session> getSessions(
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "studentId", required = false) String studentId,
            @RequestParam(value = "instructorId", required = false) String instructorId) {
        return sessionService.getSessions(studentId, instructorId, status);
    }

    // Get sessions within a date range
    @GetMapping("/date-range")
    public List<Session> getSessionsByDateRange(
            @RequestParam("startDate") String startDate, 
            @RequestParam("endDate") String endDate, 
            @RequestParam("studentId") String studentId,
            @RequestParam("instructorId") String instructorId) {
        return sessionService.getSessionsByDateRangeAndUser(startDate, endDate, studentId, instructorId);
    }

    // Get upcoming sessions for next 7 days
    @GetMapping("/upcoming")
    public List<Session> getUpcomingSessions(
        @RequestParam(value = "studentId", required = false) String studentId,
        @RequestParam(value = "instructorId", required = false) String instructorId) {
        return sessionService.getSessionsByDateRangeAndUser(null, null, studentId, instructorId);
    }

    // Update a session
    @PutMapping("/{id}")
    public Session updateSession(
            @PathVariable String id, 
            @RequestBody Session sessionDetails) {
        return sessionService.updateSession(id, sessionDetails);
    }

    // Delete a session by ID
    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable String id) {
        sessionService.deleteSession(id);
    }
}
