package com.cocode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 🌟 THE HOLY ANNOTATION
// This turns on the IoC Container and tells the flashlight scanner to read our folders!
@SpringBootApplication
public class CoCodeApplication {

    public static void main(String[] args) {
        // This launches the JVM server instance
        SpringApplication.run(CoCodeApplication.class, args);
    }
}
