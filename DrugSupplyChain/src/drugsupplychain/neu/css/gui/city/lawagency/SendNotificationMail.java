/*
 * Class : SendNotificationMail.java
 * Developer : Laksh Lumba
 * Reviewer :
 * Description : 
 * Created On : Dec 3, 2014, 6:39:40 PM
 * ---------------------------------------------------------------------------
 * Change History
 * Develper :
 * Reviwer :
 * Changed ON :
 * ---------------------------------------------------------------------------
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drugsupplychain.neu.css.gui.city.lawagency;

import drugsupplychain.neu.css.model.organization.lawAgencies.CityLawAgency;
import drugsupplychain.neu.css.model.product.ProductCase;
import drugsupplychain.neu.css.util.ImplCommonUtil;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 *
 * @author Laksh
 */
public class SendNotificationMail {
    
    public static void sendWarningMail(CityLawAgency cityLawAgency,ProductCase productCase) throws javax.mail.MessagingException{
        // Recipient's email ID needs to be mentioned.
        //String to = productCase.getDrugCaseRequest().getProduct().getManuFacturerEMAIL();
        String to = "laksh.lumba@gmail.com";
        // Sender's email ID needs to be mentioned
        String from = "laksh.lumba1989@gmail.com";
        String password = "Pillu@18";
        // Assuming you are sending email from localhost
        String host = "smtp.gmail.com";
        String smtpPort = "587";
        Properties properties = System.getProperties();
        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", smtpPort);
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true"); 
        // Authentication
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };
        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties, auth);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addHeader("Content-type", "text/HTML; charset=UTF-8");
        message.addHeader("format", "flowed");
        message.addHeader("Content-Transfer-Encoding", "8bit");
        message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
        message.setSubject("CASE: CRITICAL CASE OPENED AGAINST THE MEDICATION : " + productCase.getDrugCaseRequest().getProduct());        
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("WARNING MESSAGE");
        htmlBuilder.append("\n");
        htmlBuilder.append("CASE ID: " + productCase.getCaseId());
        htmlBuilder.append("\n");
        htmlBuilder.append("EFFECTED PESRON NAME: " + productCase.getPerson().getName());
        htmlBuilder.append("\n");
        htmlBuilder.append("PESRON ADDRESS: " + productCase.getPerson().getAddress());
        htmlBuilder.append("\n");
        htmlBuilder.append("CASE DESCRIPTION: " + productCase.getCaseDescription());
        htmlBuilder.append("\n");
        htmlBuilder.append("PROBLEM: " + productCase.getDrugCaseRequest().getMessage());
        htmlBuilder.append("\n");
        htmlBuilder.append("PROIRITY: " + productCase.getDrugCaseRequest().getPriority());
        htmlBuilder.append("\n");
        String html = htmlBuilder.toString();
        message.setText(html);
        message.setSentDate(ImplCommonUtil.getTodaysDateBYDATE());
        Transport.send(message);        
        System.out.println("Sent message successfully...."); 
    }  
}

