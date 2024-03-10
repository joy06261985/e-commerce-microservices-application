// package com.sideproject.employeeservice.controller;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.cloud.context.config.annotation.RefreshScope;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.GetMapping;
// // import org.springframework.web.bind.annotation.RequestParam;

// // force MessageController Spring Bean to reload the configuration file
// @RefreshScope
// @RestController
// public class MessageController {
// @Value("${spring.boot.message}")
// private String message;

// @GetMapping("/users/message")
// public String message() {
// return message;
// }
// }
