package com.github.fabriciolfj.springredissqs.core.service.operationmsg;

import com.github.fabriciolfj.springredissqs.core.model.User;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageSendService {

    private final QueueMessagingTemplate queueMessagingTemplate;

    public void send(final User user) {
        log.info("Sending user to sqs {}", user.toString());
        queueMessagingTemplate.convertAndSend("test", user);
    }
}
