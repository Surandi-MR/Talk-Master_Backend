package com.talkmaster.talkmaster.service;

import com.talkmaster.talkmaster.model.Package;
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
    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    // Get package by ID
    public Optional<Package> getPackageById(String id) {
        return packageRepository.findById(id);
    }

    // Create a new package
    public Package createPackage(Package pkg) {
        return packageRepository.save(pkg);
    }

    // Update an existing package
    public Package updatePackage(String id, Package packageDetails) {
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
