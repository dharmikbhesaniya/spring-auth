package com.example.demo.model.entity.base;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@ToString
@EntityListeners({AuditingEntityListener.class, EntityAuditListener.class})
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE #{#entityName} SET is_deleted = true, soft_deleted_at = CURRENT_TIMESTAMP WHERE id = ? AND version = ?")
@Where(clause = "is_deleted = false")
public abstract class BaseEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @CreatedBy
    @Column(name = "created_by", updatable = false, length = 100)
    private String createdBy;

    @LastModifiedBy
    @Column(name = "updated_by", length = 100)
    private String updatedBy;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = Boolean.FALSE;

    @Column(name = "soft_deleted_at")
    private LocalDateTime softDeletedAt;

    @Column(name = "soft_deleted_by", length = 100)
    private String softDeletedBy;

    @Version
    @Column(name = "version")
    private Long version;

    /**
     * Marks this entity as soft deleted
     *
     * @param deletedBy the user who performed the deletion
     */
    public void softDelete(String deletedBy) {
        this.isDeleted = Boolean.TRUE;
        this.softDeletedAt = LocalDateTime.now();
        this.softDeletedBy = deletedBy;
    }

    /**
     * Restores a soft deleted entity
     */
    public void restore() {
        this.isDeleted = Boolean.FALSE;
        this.softDeletedAt = null;
        this.softDeletedBy = null;
    }

    /**
     * Checks if the entity is soft deleted
     *
     * @return true if the entity is soft deleted
     */
    public boolean isSoftDeleted() {
        return Boolean.TRUE.equals(this.isDeleted);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BaseEntity that = (BaseEntity) obj;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}

