package com.talkmaster.talkmaster.repository;

import com.talkmaster.talkmaster.model.UserPackage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPackageRepository extends MongoRepository<UserPackage, String> {
    List<UserPackage> findByUserId(String userId);
    List<UserPackage> findByPackageId(String packageId);
    List<UserPackage> findByUserIdAndPackageId(String userId, String packageId);
}
