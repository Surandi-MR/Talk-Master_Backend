package com.talkmaster.talkmaster.repository;

import com.talkmaster.talkmaster.model.Package;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PackageRepository extends MongoRepository<Package, String> {
}
