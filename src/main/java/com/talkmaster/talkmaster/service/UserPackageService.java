package com.talkmaster.talkmaster.service;

import com.talkmaster.talkmaster.model.PackageModel;
import com.talkmaster.talkmaster.model.UserPackage;
import com.talkmaster.talkmaster.repository.UserPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserPackageService {

    @Autowired
    private UserPackageRepository userPackageRepository;

    @Autowired
    private PackageService packageService;

    // Assign a package to a user
    public UserPackage assignPackageToUser(String userId, String packageId) {
        PackageModel pkg = packageService.getPackageById(packageId)
                .orElseThrow(() -> new RuntimeException("UserPackage not found"));
        
        UserPackage userPackage = new UserPackage();
        userPackage.setUserId(userId);
        userPackage.setPackageId(packageId);
        userPackage.setPurchaseDate(LocalDateTime.now());
        userPackage.setRemainingSessions(pkg.getSessions());
        return userPackageRepository.save(userPackage);
    }

    // Get all packages purchased by a user
    public List<UserPackage> getPackagesByUser(String userId) {
        List<UserPackage> userPackages = userPackageRepository.findByUserId(userId);
        for(UserPackage userPackage : userPackages) {
            userPackage.setPackageModel(packageService.getPackageById(userPackage.getPackageId())
                    .orElseThrow(() -> new RuntimeException("Package not found")));
        }
        return userPackages;
    }

    // Get all users who purchased a specific package
    public List<UserPackage> getUsersByPackage(String packageId) {
        return userPackageRepository.findByPackageId(packageId);
    }

    // Update remaining session hours for a user-package relationship
    public UserPackage updateRemainingSessions(String userPackageId, int remainingSessions) {
        UserPackage userPackage = userPackageRepository.findById(userPackageId)
                .orElseThrow(() -> new RuntimeException("UserPackage not found"));
        userPackage.setRemainingSessions(remainingSessions);
        return userPackageRepository.save(userPackage);
    }

    // Get all active packages for a user
    public List<UserPackage> getActivePackagesWithDetails(String userId) {
        List<UserPackage> activeUserPackages =  userPackageRepository.findByUserIdAndRemainingSessionsGreaterThan(userId, 0);
        for(UserPackage userPackage : activeUserPackages) {
            userPackage.setPackageModel(packageService.getPackageById(userPackage.getPackageId())
                    .orElseThrow(() -> new RuntimeException("Package not found")));
        }
        return activeUserPackages;
    }
}
