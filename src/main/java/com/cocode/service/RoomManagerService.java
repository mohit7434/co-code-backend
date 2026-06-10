package com.cocode.service;

import com.cocode.model.RoomTracker;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class RoomManagerService {

    public boolean validateAndAddUser(String roomId, String username) {
        if (username == null || username.trim().isEmpty()) return false;
        RoomTracker.addUserToRoom(roomId, username.trim());
        return true;
    }

    public List<String> getActiveUsers(String roomId) {
        return RoomTracker.getUsersInRoom(roomId);
    }

    // 🌟 NEW METHOD: Writes the real-time code buffer directly to a physical file on disk
    public String saveRoomCodeToDisk(String roomId, String codeContent) {
        try {
            // Create a clean, unique filename based on the Room ID
            String fileName = "saved_" + roomId + ".txt";
            Path path = Paths.get(fileName);

            // Write the string characters into bytes on your hard drive
            Files.writeString(path, codeContent);

            System.out.println("💾 Absolute path success! Saved to: " + path.toAbsolutePath());
            return "Successfully saved to " + fileName;
        } catch (IOException e) {
            System.err.println("❌ Failed to write file to disk: " + e.getMessage());
            return "Error saving file: " + e.getMessage();
        }
    }
}