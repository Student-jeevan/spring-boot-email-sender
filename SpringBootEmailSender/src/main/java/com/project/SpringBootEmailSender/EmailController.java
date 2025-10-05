package com.project.SpringBootEmailSender;

import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

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
    @RequestMapping("/send-email-with-attach")
    public String sendEmailWithAttachment(){
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper  = new MimeMessageHelper(message , true);
            helper.setFrom("jeevanthitra@gmail.com");
            helper.setTo("jeevanthitrya@gmail.com");
            helper.setSubject("java email with attachments");
            helper.setText("find email with attachment");
            helper.addAttachment("Oracle.pdf" , new File("C:\\Users\\hp\\OneDrive\\Desktop\\Certificates\\Oracle.pdf"));
            helper.addAttachment("semresults.pdf" , new File("C:\\Users\\hp\\OneDrive\\Desktop\\Certificates\\semresults.pdf"));
            javaMailSender.send(message);
            return "Success!";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }
    @RequestMapping("/send-html-email")
    public String sendEmailWithHtmlBody(){
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper  = new MimeMessageHelper(message , true);
            helper.setFrom("jeevanthitra@gmail.com");
            helper.setTo("jeevanthitrya@gmail.com");
            helper.setSubject("java email with attachments");
            helper.setText("find email with attachment");
            try(var inputStream = Objects.requireNonNull(EmailController.class.getResourceAsStream("/templates/email-sample.html"))){
                helper.setText(new String(inputStream.readAllBytes() , StandardCharsets.UTF_8), true);
            }
            javaMailSender.send(message);
            return "Success!";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }
}
