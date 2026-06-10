package com.cocode.model;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RoomTracker {

    // 🌟 THE HEAP STORAGE
    // Maps a unique Room ID (String) to a List of active User IDs inside that room.
    // We use ConcurrentHashMap because multiple web threads will modify this concurrently!
    private static final ConcurrentHashMap<String, List<String>> roomUsersMap = new ConcurrentHashMap<>();

    // Method to add a user to a specific room safely
    public static void addUserToRoom(String roomId, String userId) {
        // computeIfAbsent is an atomic operation on ConcurrentHashMap.
        // It ensures if the room doesn't exist, a new ArrayList is safely instantiated.
        roomUsersMap.computeIfAbsent(roomId, k -> new ArrayList<>()).add(userId);
    }

    // Method to get all active users in a room
    public static List<String> getUsersInRoom(String roomId) {
        return roomUsersMap.getOrDefault(roomId, new ArrayList<>());
    }
}