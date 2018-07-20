package test;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailSSL {
	
	public static void send(String companyName, String recipientEmailID) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "SMTP-HOST");
		props.put("mail.smtp.socketFactory.port", "465 ");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("mail@id.com","password");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("nikhil.bhole@domsit.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(recipientEmailID));
			
			message.setSubject("We are Human Resource and Placement Company in Pune.");
			
			message.setText("Hello " + companyName + "\n"
					+ "Greetings from domsit.com !!!!! \n"
					+"We at DomS IT Solutions Pvt. Ltd. is one of the fastest growing IT / Non IT recruitment firm in Pune, India. We proudly state that our expert recruitment team collects the talent according to your organizational needs and specifications, thereby provides the best quality staff and fulfills all the HR related requirements. We are specialized in providing experienced and fresher candidates for various IT fields.\n" + 
					"\n" + 
					"We are in a position to provide you with the best candidates from different parts of the country. \n" + 
					"\n" + 
					"Here are some of our clients :\n" + 
					"Reliance Jio\n" + 
					"ITC Infotech India Ltd.\n" + 
					"AGS Technologies India Pvt. Ltd. \n" + 
					"Contours Interio Pvt. Ltd.\n" + 
					"\n" + 
					"I strongly believe that our experts will be able to provide you the best staff that fits in a job role which bridges the gap between employee and employer. \n" + 
					"\n" + 
					"For any assistance, please feel free to contact us at any time at marketing@domsit.com\n" + 
					"\n" + 
					"Hoping to get a chance to provide you with our best services. Looking for your favourable reply."
					
					);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
