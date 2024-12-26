package com.talkmaster.talkmaster.repository;

import com.talkmaster.talkmaster.model.PackageModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PackageRepository extends MongoRepository<PackageModel, String> {
}
