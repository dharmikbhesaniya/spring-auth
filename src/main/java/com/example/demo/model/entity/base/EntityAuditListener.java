package com.example.demo.model.entity.base;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

public class EntityAuditListener {

  @PrePersist
  public void prePersist(Object entity) {
    System.out.println("Before creating: " + entity.getClass().getSimpleName());
  }

  @PreUpdate
  public void preUpdate(Object entity) {
    System.out.println("Before updating: " + entity.getClass().getSimpleName());
  }

  @PreRemove
  public void preRemove(Object entity) {
    System.out.println("Before deleting (soft): " + entity.getClass().getSimpleName());
  }
}
