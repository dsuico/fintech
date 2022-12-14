package com.peerLending.securityapp.application;

import com.peerLending.securityapp.user.dto.UserDto;
import com.peerLending.securityapp.user.exception.UserNotFoundException;
import com.peerLending.securityapp.user.model.User;
import com.peerLending.securityapp.user.model.repository.UserRepository;
import com.peerLending.securityapp.user.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final NotificationService notificationService;

    @Autowired
    public UserController(UserRepository userRepository, NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    @PostMapping("/register")
    public void register(@RequestBody UserDto userDto) {
        User user = new User(userDto.getUsername(), userDto.getPassword());
        userRepository.save(user);
        notificationService.sendMessage(userDto);
    }

    @PostMapping("/validate")
    public String validateTokenAndGetUsername(@RequestHeader("Authorization") String token) {
        return userRepository.findById(token).orElseThrow(() -> new UserNotFoundException()).getUsername();
    }
}
