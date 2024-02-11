package com.example.servergraphql.util;


import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import java.io.IOException;
import java.util.Properties;


@Getter
@Log4j2
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@org.springframework.context.annotation.Configuration
public class Configuration {


    private String password;
    private String userkeystore;
    private String username;

    public Configuration() {
        try {
            Properties p = new Properties();
            p.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            this.username = p.getProperty("username");
            this.password = p.getProperty("password");
            this.userkeystore = p.getProperty("keystore");

        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }


}

