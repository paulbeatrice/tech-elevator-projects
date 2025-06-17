package com.techelevator.controller;

import com.techelevator.model.Package;
import com.techelevator.service.PackageService;
import com.techelevator.service.PageSpeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/packages")

public class PackageController {

    private final PackageService packageService;

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping
    public ResponseEntity<List<Package>> getAllPackages() {
        List<Package> packages = packageService.getAllPackages();
        return ResponseEntity.ok(packages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Package> getPackageById(@PathVariable int id) {
        Package seoPackage = packageService.getPackageById(id);
        if (seoPackage != null) {
            return ResponseEntity.ok(seoPackage);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    //Create a new SEO Package (ADMIN ONLY)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Package> createPackage(@RequestBody Package newPackage) {
        Package createdPackage = packageService.createPackage(newPackage);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPackage);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Package> updatePackage(@PathVariable int id, @RequestBody Package updatedPackage) {
        updatedPackage.setPackageId(id);
        boolean success = packageService.updatePackage(updatedPackage);
        if (success) {
            return ResponseEntity.ok(updatedPackage);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackage(@PathVariable int id) {
        boolean success = packageService.deletePackage(id);
        if (success) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
