package com.cmpe275.cusr.service;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

@Service @Transactional
public class EmailService {

	public void sendHtmlEmail(String toAddress, String message) throws AddressException, MessagingException {

		// SMTP server information
		String host = "smtp.gmail.com";
		String port = "587";
		String mailFrom = "smartcitystaff1@gmail.com";
		String password = "smartcity123";

		// outgoing message information
		String subject = "Ticket Booking Confirmation";

		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailFrom, password);
			}
		};

		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(mailFrom));
		InternetAddress[] toAddresses = {new InternetAddress(toAddress)};
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		// set plain text message
		msg.setContent(message, "text/html");

		// sends the e-mail
		Transport.send(msg);

	}


	public void sendRebookingConfirmation(String toAddress, String message)throws AddressException, MessagingException {

		// SMTP server information
		String host = "smtp.gmail.com";
		String port = "587";
		String mailFrom = "smartcitystaff1@gmail.com";
		String password = "smartcity123";

		// outgoing message information
		String subject = "Booking Confirmation";

		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailFrom, password);
			}
		};

		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(mailFrom));
		InternetAddress[] toAddresses = {new InternetAddress(toAddress)};
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		// set plain text message
		msg.setContent(message, "text/html");

		// sends the e-mail
		Transport.send(msg);
	}
}