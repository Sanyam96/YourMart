package com.nagarro.yourmart.domains;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @author Sanyam Goel created on 29/10/18
 */
@MappedSuperclass
public class BaseEntity {

    @Column(name = "created_at", updatable = false, nullable = false)
    protected long createdAt;

    @Column(name = "updated_at", updatable = false, nullable = false)
    protected long updatedAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = System.currentTimeMillis();
    }


    //    Getters and Setters
    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    //     Constructors
    public BaseEntity(long createdAt, long updatedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public BaseEntity() {

    }
}