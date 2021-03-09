package com.github.fabriciolfj.springredissqs.application;

import com.github.fabriciolfj.springredissqs.core.model.User;
import com.github.fabriciolfj.springredissqs.core.service.cruduser.UserService;
import com.github.fabriciolfj.springredissqs.core.service.operationmsg.MessageSendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.websocket.server.PathParam;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final MessageSendService sqsSender;
    private final UserService userService;

    @GetMapping
    public User getById(@PathParam("id") Integer id) {
        return userService.getById(id);
    }

    @GetMapping("/all")
    public Map<Integer, User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public boolean create(@RequestBody User user) {
        log.info("Creating User...");
        sqsSender.send(user);
        return true;
    }
}
