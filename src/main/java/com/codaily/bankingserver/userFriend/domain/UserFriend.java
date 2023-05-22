package com.codaily.bankingserver.userFriend.domain;

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
public class UserFriend{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User userId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="friend_id")
    private User friendId;
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp updatedAt;

    @Builder
    public UserFriend(User userId, User friendId) {
        this.userId = userId;
        this.friendId = friendId;
    }
}