package com.cocode.model;

public class CodeUpdatePayload {
    private String roomId;
    private String senderId;
    private String username; // 🌟 Add this field to catch the incoming frontend parameter!
    private String codeContent;

    public CodeUpdatePayload() {}

    // Add getter and setter for username so the reflection engine can bind the text
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }

    public String getSenderId() { return senderId; }
    public void setSenderId(String senderId) { this.senderId = senderId; }

    public String getCodeContent() { return codeContent; }
    public void setCodeContent(String codeContent) { this.codeContent = codeContent; }
}