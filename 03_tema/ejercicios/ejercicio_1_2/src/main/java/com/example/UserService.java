package com.example;

import org.springframework.stereotype.Component;

@Component
public class UserService {
    private NotificationService service;

    public UserService(NotificationService service) {
        this.service = service;
    }

    public NotificationService getService() {
        return service;
    }

    public void setService(NotificationService service) {
        this.service = service;
    }
}
