package com.talkmaster.talkmaster.repository;

import com.talkmaster.talkmaster.model.UserPackage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPackageRepository extends MongoRepository<UserPackage, String> {

    /**
     * Finds all UserPackage entities by the given userId.
     */
    List<UserPackage> findByUserId(String userId);

    /**
     * Finds all UserPackage entities by the given packageId.
     */
    List<UserPackage> findByPackageId(String packageId);

    /**
     * Finds all UserPackage entities by the given userId and packageId.
     */
    List<UserPackage> findByUserIdAndPackageId(String userId, String packageId);

    /**
     * Finds all UserPackage entities by the given userId and where remainingSessions is greater than the specified value.
     */
    List<UserPackage> findByUserIdAndRemainingSessionsGreaterThan(String userId, int remainingSessions);
}
