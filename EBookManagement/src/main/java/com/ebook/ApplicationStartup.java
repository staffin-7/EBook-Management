package com.ebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.ebook.constants.Constants;
import com.ebook.entity.User;
import com.ebook.service.UserService;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        initDatabaseEntities();
    }


    private void initDatabaseEntities() {

        if( userService.getAllUsers().size() == 0) {
            userService.addNew(new User("User", "admin", "admin", Constants.ROLE_ADMIN));
            userService.addNew(new User("User2", "librarian", "librarian", Constants.ROLE_LIBRARIAN));
        }

    }
}