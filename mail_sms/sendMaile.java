package mail_sms;


import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
import java.util.*;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;

public class sendMaile {  
 public static void sendMail(String recepient,String str)throws Exception{
    System.out.println("Preparing to send");
    Properties properties = new Properties();
    properties.put("mail.smtp.ssl.trust", "smtp.outlook.com");
    properties.put("mail.smtp.auth","true");
    //mail.smtp.ssl.protocols=TLSv1.2;
    properties.put("mail.smtp.starttls.enable","true");
    properties.put("mail.smtp.host","smtp.outlook.com");
    properties.put("mail.smtp.ssl.trust", "smtp.outlook.com");
    properties.put("mail.smtp.port","587");
    properties.put("mail.smtp.ssl.trust", "smtp.outlook.com");
    properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
    //properties.put("mail.smtp.socketFactory.port", "587");
//properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
//properties.put("mail.smtp.socketFactory.fallback", "false");
    String myAccountEmail = "event.s.planner@outlook.com";
    String password = "yoge2417";
    
    Session session = Session.getInstance(properties,new Authenticator(){
      @Override
      protected PasswordAuthentication getPasswordAuthentication(){
           return new PasswordAuthentication(myAccountEmail,password);
      }
    });
    Message message = prepareMessage(session,myAccountEmail,recepient,str);
    Transport.send(message);
    System.out.println("Message sent");
}
 private static Message prepareMessage(Session session, String myAccountEmail, String recepient,String str){
    try{
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(myAccountEmail));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
        message.setSubject("SIGN UP CODE");
        String htmlCode = "<h3> WE ARE DELIGHTED TO WELCOME YOU ONBOARD  </h3> <br>SIGN UP USING THIS CODE :" + str+"<br><br><br><br> Thanks & Regards <br> Signature Soire`es";
        message.setContent(htmlCode,"text/html");
        return message;
    }
    catch (Exception ex){
        System.out.println("error");
}
 return null;
}
 public static void main(String[] args) throws Exception {  

                 sendMail("sriyogesh2020@gmail.com","Your Booking Has Been Confirmed");
                 System.out.println("sent");
    
 
       }

} 
