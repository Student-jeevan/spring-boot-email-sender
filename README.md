# Java Mail Sender Project

This is a simple **Spring Boot** project that demonstrates sending emails using JavaMailSender.

## Features

- Send a simple text email.
- Send email with attachments.
- Send HTML email using an HTML template.

## Setup

1. Configure your Gmail account and enable **App Passwords**.
2. Update `application.properties`:
```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```
3. Place your HTML email template in `src/main/resources/templates/email-sample.html`.

## Endpoints

| Endpoint | Description |
|----------|-------------|
| `/send-email` | Sends a simple text email |
| `/send-email-with-attach` | Sends email with attachments |
| `/send-html-email` | Sends HTML email from template |

## How to Run

1. Build and run Spring Boot application.
2. Access endpoints via browser or Postman.

---

This project is for **practice purposes** to understand sending emails with Spring Boot.
