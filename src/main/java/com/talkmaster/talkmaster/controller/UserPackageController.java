package com.talkmaster.talkmaster.controller;

import com.talkmaster.talkmaster.model.UserPackage;
import com.talkmaster.talkmaster.service.UserPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-packages")
public class UserPackageController {

    @Autowired
    private UserPackageService userPackageService;

    // Assign a package to a user
    @PostMapping
    public UserPackage assignPackageToUser(
            @RequestParam String userId,
            @RequestParam String packageId) {
        return userPackageService.assignPackageToUser(userId, packageId);
    }

    // Get all packages purchased by a user
    @GetMapping("/user/{userId}")
    public List<UserPackage> getPackagesByUser(@PathVariable String userId) {
        return userPackageService.getPackagesByUser(userId);
    }

    // Get all users who purchased a specific package
    @GetMapping("/package/{packageId}")
    public List<UserPackage> getUsersByPackage(@PathVariable String packageId) {
        return userPackageService.getUsersByPackage(packageId);
    }

    // Update remaining sessions
    @PutMapping("/{id}")
    public UserPackage updateRemainingSessions(
            @PathVariable String id,
            @RequestParam int remainingSessions) {
        return userPackageService.updateRemainingSessions(id, remainingSessions);
    }

    // Get all active packages for a user
    @GetMapping("/active/{userId}")
    public List<UserPackage> getActivePackages(@PathVariable String userId) {
        return userPackageService.getActivePackagesWithDetails(userId);
    }
}
