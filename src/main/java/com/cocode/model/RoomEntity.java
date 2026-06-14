package com.cocode.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
@SuppressWarnings("unused") // 🌟 This removes the red "never used" visual warnings in your IDE
public class RoomEntity {

    @Id
    private String roomId;

    @Column(columnDefinition = "TEXT")
    private String currentCode;

    // Standard constructor required by JPA
    public RoomEntity() {}

    public RoomEntity(String roomId, String currentCode) {
        this.roomId = roomId;
        this.currentCode = currentCode;
    }

    // Getters and Setters
    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }

    public String getCurrentCode() { return currentCode; }
    public void setCurrentCode(String currentCode) { this.currentCode = currentCode; }
}