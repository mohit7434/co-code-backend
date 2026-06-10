package com.cocode.controller;

import com.cocode.model.CodeUpdatePayload;
import com.cocode.model.UserJoinPayload;
import com.cocode.service.RoomManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*; // 🌟 Import web annotations
import java.util.List;

@RestController // 🌟 Changes this controller to handle both WebSocket and HTTP REST traffic!
@CrossOrigin(origins = "*") // Prevents browser security blocks
public class CodeBoardController {

    @Autowired
    private RoomManagerService roomManagerService;

    @MessageMapping("/update-code")
    @SendTo("/topic/code")
    public CodeUpdatePayload broadcastCodeUpdate(CodeUpdatePayload payload) {
        if (payload.getSenderId() == null) {
            payload.setSenderId(payload.getUsername());
        }
        return payload;
    }

    @MessageMapping("/join-room")
    @SendTo("/topic/users")
    public List<String> handleUserJoin(UserJoinPayload payload) {
        roomManagerService.validateAndAddUser(payload.getRoomId(), payload.getUsername());
        return roomManagerService.getActiveUsers(payload.getRoomId());
    }

    // 🌟 NEW REST ENDPOINT: Listens for a browser HTTP POST to save the current text state
    @PostMapping("/api/rooms/{roomId}/save")
    public String saveCode(@PathVariable String roomId, @RequestBody String codeContent) {
        return roomManagerService.saveRoomCodeToDisk(roomId, codeContent);
    }
}