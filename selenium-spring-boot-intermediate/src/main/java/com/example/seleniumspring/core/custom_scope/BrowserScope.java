package com.example.seleniumspring.core.custom_scope;

// Creating Custom Scope From Scratch.
//public class BrowserScope implements org.springframework.beans.factory.config.Scope {
//}

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;

import java.util.Objects;

/*
    Our Custom Scope Definition.
 */
public class BrowserScope extends SimpleThreadScope {
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Object _obj = super.get(name, objectFactory);
        RemoteWebDriver driver = (RemoteWebDriver) _obj;
        SessionId sessionId = driver.getSessionId();
        if (Objects.isNull(sessionId)) { // If sessionId is null.
            super.remove(name);  // Remove the driver
            _obj = super.get(name, objectFactory); // Get a new instance of driver
        }
        return _obj;
    }
    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        // Destructor callback should be blank.
//        super.registerDestructionCallback(name, callback);
    }
}