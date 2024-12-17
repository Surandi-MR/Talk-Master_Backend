package com.talkmaster.talkmaster.controller;

import com.talkmaster.talkmaster.model.Package;
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
    public List<Package> getAllPackages() {
        return packageService.getAllPackages();
    }

    // Get a package by ID
    // @GetMapping("/{id}")
    // public Package getPackageById(@PathVariable String id) {
    //     return packageService.getPackageById(id)
    //             .orElseThrow(() -> new RuntimeException("Package not found with id " + id));
    // }

    // Create a new package
    @PostMapping("/create")
    public Package createPackage(@RequestBody Package pkg) {
        return packageService.createPackage(pkg);
    }

    // Update a package by ID
    @PutMapping("/{id}")
    public Package updatePackage(@PathVariable String id, @RequestBody Package packageDetails) {
        return packageService.updatePackage(id, packageDetails);
    }

    // Delete a package by ID
    @DeleteMapping("/{id}")
    public String deletePackage(@PathVariable String id) {
        packageService.deletePackage(id);
        return "Package deleted successfully!";
    }
}
