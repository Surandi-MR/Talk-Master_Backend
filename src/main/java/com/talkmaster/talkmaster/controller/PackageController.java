package com.talkmaster.talkmaster.controller;

import com.talkmaster.talkmaster.model.PackageModel;
import com.talkmaster.talkmaster.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Marks this class as a RESTful controller
@RequestMapping("/api/package") // Define the endpoint
public class PackageController {
    @Autowired //call methods in package service
    private PackageService packageService;

    // Get all packages
    @GetMapping("/all")
    public List<PackageModel> getAllPackages() {
        return packageService.getAllPackages();
    }

    // Get a package by ID
    @GetMapping("/{id}")
    public PackageModel getPackageById(@PathVariable String id) {
        return packageService.getPackageById(id)
                .orElseThrow(() -> new RuntimeException("Package not found with id " + id));
    }

    // Create a new package
    @PostMapping("/create")
    public PackageModel createPackage(@RequestBody PackageModel pkg) {
        return packageService.createPackage(pkg);
    }

    // Update a package by ID
    @PutMapping("/{id}")
    public PackageModel updatePackage(@PathVariable String id, @RequestBody PackageModel packageDetails) {
        return packageService.updatePackage(id, packageDetails);
    }

    // Delete a package by ID
    @DeleteMapping("/{id}")
    public String deletePackage(@PathVariable String id) {
        packageService.deletePackage(id);
        return "Package deleted successfully!";
    }
}
