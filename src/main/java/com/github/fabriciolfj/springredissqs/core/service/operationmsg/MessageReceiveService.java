package com.github.fabriciolfj.springredissqs.core.service.operationmsg;

import com.github.fabriciolfj.springredissqs.core.model.User;
import com.github.fabriciolfj.springredissqs.core.service.cruduser.UserService;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageReceiveService {

    private final UserService userService;

    @SqsListener("test")
    public void userCacheListener(final User user) {
        log.info("Received Message for user... {}", user.toString());
        userService.save(user);
        log.info("Save message in cache");
    }

}
