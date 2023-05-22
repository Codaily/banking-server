package com.codaily.bankingserver.accountInfo.domain;

import com.codaily.bankingserver.account.domain.Account;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
public class AccountInfo {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="account_number")
    private Account accountNumber;

    @Column(nullable = false, length = 100)
    private String groupAccountNumber;

    @ColumnDefault("0")
    private BigInteger balance;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    @Builder AccountInfo(Account accountNumber, String groupAccountNumber, BigInteger balance) {
        this.accountNumber = accountNumber;
        this.groupAccountNumber = groupAccountNumber;
        this.balance = balance;
    }
}
