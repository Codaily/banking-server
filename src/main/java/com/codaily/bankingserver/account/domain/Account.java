package com.codaily.bankingserver.account.domain;

import com.codaily.bankingserver.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
public class Account {

    @Id
    @Column(nullable = false, length = 100)
    private String accountNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User userId;

    @Column(nullable = false, length = 50)
    private String accountPassword;

    @Column
    private String authority;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    @Builder Account(String accountNumber, User userId, String accountPassword){
        this.accountNumber = accountNumber;
        this.userId = userId;
        this.accountPassword = accountPassword;
    }

}
