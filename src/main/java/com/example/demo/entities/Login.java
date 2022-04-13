package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loginId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(updatable = false)
    private LocalDateTime createdDateTime;
    private LocalDateTime modifiedTime;
    private boolean isActive = true;

    @PrePersist
    protected void onCreate(){
        this.createdDateTime = LocalDateTime.now();
    }

}
