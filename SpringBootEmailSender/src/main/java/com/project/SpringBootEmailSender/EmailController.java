package com.project.SpringBootEmailSender;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    private final JavaMailSender javaMailSender;
    public EmailController(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }
    @RequestMapping("/send-email")
    public String sendEmail(){
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("jeevanthitra@gmail.com");
            message.setTo("jeevanthitrya@gmail.com");
            message.setSubject("Simple text from application ");
            message.setText("this is simple mail from java mail sender");
            javaMailSender.send(message);
            return "Success!";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }

}
