package com.cocode.service;

import com.cocode.Repository.RoomRepository;
import com.cocode.model.RoomEntity;
import com.cocode.model.RoomTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Service
public class RoomManagerService {

    @Autowired
    private RoomRepository roomRepository;

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
            // 1. Package the incoming data payload straight into our Database Entity class
            RoomEntity roomEntity = new RoomEntity(roomId, codeContent);

            // 2. Fire the object into the database via the JPA Repository
            roomRepository.save(roomEntity);

            return "Successfully saved Room [" + roomId + "] to the H2 Database!";
        } catch (Exception e) {
            // Even with databases, unexpected connection or lock issues can happen!
            return "Error saving to database: " + e.getMessage();
        }
    }
}