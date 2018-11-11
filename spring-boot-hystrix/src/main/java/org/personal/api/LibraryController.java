package org.personal.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicBoolean;

@RestController
public class LibraryController {
    private AtomicBoolean serverStatus = new AtomicBoolean(true);


    @RequestMapping("/server/start")
    public void start() {
        serverStatus.set(true);
    }

    @RequestMapping("/server/stop")
    public void stop() {
        serverStatus.set(false);
    }

    @RequestMapping("/server/books")
    public String getBooks() {
        if (serverStatus.get()) {
            return "The God Delusion, Home Deus and Thinking Fast and Slow";
        } else {
            throw new RuntimeException("Server controller is stopped");
        }
    }
}