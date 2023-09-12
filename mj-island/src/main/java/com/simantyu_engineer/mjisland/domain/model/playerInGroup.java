package com.simantyu_engineer.mjisland.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "player_in_group")
@IdClass(value = PlayerInGroupKey.class)
public class PlayerInGroup {
    
    @Id
    @Column(name = "player_id")
    private String playerId;
    
    @Id
    @Column(name = "group_id")
    private String groupId;
   
    @Column(name = "create_user")
    private String create_user;
    
    @Column(name = "create_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime create_datetime;
    
    @Column(name = "update_user")
    private String update_user;

    @Column(name = "update_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime update_datetime;
}
