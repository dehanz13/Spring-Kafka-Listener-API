package com.danzydon.api.kafkalistener.resources;

import com.danzydon.api.kafkalistener.model.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @PostMapping(path = "/send/foo/{name}")
    public void sendFoo(@PathVariable String what) {
        this.template.send("topic1", new UserRecord());
    }
}
