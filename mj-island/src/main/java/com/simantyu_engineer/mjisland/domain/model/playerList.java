package com.simantyu_engineer.mjisland.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "player_list")
public class PlayerList implements Comparable<PlayerList> {
    @Id
    @Column(name = "player_id")
    private String playerId;

    @Column(name = "player_id_name")
    private String player_id_name;

    @Column(name = "player_name")
    private String player_name;

    @Column(name = "comment")
    private String comment;

    @Column(name = "create_member_id")
    private String create_member_id;

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

    /**
     * sort用（player_name順）
     */
    @Override
    public int compareTo(PlayerList another) {
        return this.player_name.compareTo(another.player_name);
    }
}
