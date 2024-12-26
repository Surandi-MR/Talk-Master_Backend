package com.talkmaster.talkmaster.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "user_packages")
public class UserPackage {

    @Id
    private String id;
    private String userId; // References User.id
    private String packageId; // References Package.id
    private LocalDateTime purchaseDate;
    private int remainingSessions;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    } 

    public int getRemainingSessions() {
        return remainingSessions;
    }

    public void setRemainingSessions(int remainingSessions) {
        this.remainingSessions = remainingSessions;
    }
}
