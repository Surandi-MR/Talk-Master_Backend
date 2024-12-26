package com.talkmaster.talkmaster.service;

import com.talkmaster.talkmaster.model.PackageModel;
import com.talkmaster.talkmaster.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageService {
    @Autowired
    private PackageRepository packageRepository;

    // Get all packages
    public List<PackageModel> getAllPackages() {
        return packageRepository.findAll();
    }

    // Get package by ID
    public Optional<PackageModel> getPackageById(String id) {
        return packageRepository.findById(id);
    }

    // Create a new package
    public PackageModel createPackage(PackageModel pkg) {
        return packageRepository.save(pkg);
    }

    // Update an existing package
    public PackageModel updatePackage(String id, PackageModel packageDetails) {
        return packageRepository.findById(id).map(existingPackage -> {
            existingPackage.setName(packageDetails.getName());
            existingPackage.setPrice(packageDetails.getPrice());
            existingPackage.setSessions(packageDetails.getSessions());
            existingPackage.setDuration(packageDetails.getDuration());
            existingPackage.setDescription(packageDetails.getDescription());
            return packageRepository.save(existingPackage);
        }).orElseThrow(() -> new RuntimeException("Package not found with id " + id));
    }

    // Delete a package by ID
    public void deletePackage(String id) {
        packageRepository.deleteById(id);
    }
}
