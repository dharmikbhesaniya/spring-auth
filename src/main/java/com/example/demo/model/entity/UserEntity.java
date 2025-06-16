package com.example.demo.model.entity;

import com.example.demo.model.entity.base.BaseEntity;
import com.example.demo.utils.enums.UserRoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "app_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE user SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
public class UserEntity extends BaseEntity {

    @Column(nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRoleEnum role;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Boolean enabled = true;
}
