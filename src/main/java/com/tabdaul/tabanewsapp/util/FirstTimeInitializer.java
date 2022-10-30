package com.tabdaul.tabanewsapp.util;

import com.tabdaul.tabanewsapp.Entities.User;
import com.tabdaul.tabanewsapp.services.UserServiceImpl;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FirstTimeInitializer implements CommandLineRunner {

    private final Log logger = LogFactory.getLog(FirstTimeInitializer.class);

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Override
    public void run(String... args) throws Exception {

        // TODO: Make the administrator by default in this method
        if (userServiceImpl.findAll().isEmpty()) {
            logger.info("No user accounts found. Creating some users...");

            User user = new User("Mosaed", "masaadbal@gmail.com", "pass123");
            userServiceImpl.save(user);
        }

        // If no users exist, create some users.

    }
}
