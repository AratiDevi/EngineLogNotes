package MenusList;

import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import CommanFunction.RW;

public class SendEmail extends RW {

	public void Send() {

		// Recipient's email ID needs to be mentioned.
		final String username = data.getData(2, 6, 2);
		final String password = data.getData(2, 7, 2);

		// Get system properties
		Properties props = new Properties();

		props.put("mail.smtp.user", "username");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "25");
		props.put("mail.debug", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.EnableSSL.enable", "true");

		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);

			MimeBodyPart messageBodyPart = new MimeBodyPart();

			message.setFrom(new InternetAddress(data.getData(2, 6, 2)));

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(data.getData(2, 9, 2)));

			message.setSubject(data.getData(2, 15, 2));

			messageBodyPart.setText("Dear sir,");

			Multipart multipart = new MimeMultipart();

			String file = data.getData(2, 11, 2);

			String fileName = data.getData(2, 13, 2);

			DataSource source = new FileDataSource(file);

			messageBodyPart.setText("File Report");

			messageBodyPart.setDataHandler(new DataHandler(source));

			messageBodyPart.setFileName(fileName);

			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			System.out.println("Sending...........");

			Transport.send(message);

			System.out.println("Done.....");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

		/*
		 * 
		 * 
		 * final String username = "amitnandhas@gmail.com"; final String
		 * password = "9824189414";
		 * 
		 * Properties props = new Properties();
		 * props.put("mail.smtp.user","username"); props.put("mail.smtp.host",
		 * "smtp.gmail.com"); props.put("mail.smtp.port", "25");
		 * props.put("mail.debug", "true"); props.put("mail.smtp.auth", "true");
		 * props.put("mail.smtp.starttls.enable","true");
		 * props.put("mail.smtp.EnableSSL.enable","true");
		 * 
		 * props.setProperty("mail.smtp.socketFactory.class",
		 * "javax.net.ssl.SSLSocketFactory");
		 * props.setProperty("mail.smtp.socketFactory.fallback", "false");
		 * props.setProperty("mail.smtp.port", "465");
		 * props.setProperty("mail.smtp.socketFactory.port", "465");
		 * 
		 * Session session = Session.getInstance(props, new
		 * javax.mail.Authenticator() { protected PasswordAuthentication
		 * getPasswordAuthentication() { return new
		 * PasswordAuthentication(username, password); } });
		 * 
		 * try {
		 * 
		 * Message message = new MimeMessage(session); message.setFrom(new
		 * InternetAddress("amitnandhas@gmail.com"));
		 * message.setRecipients(Message.RecipientType.TO,
		 * InternetAddress.parse("amit.nanda@jibe.com.sg")); message.setSubject(
		 * "Testing report of jibe menu"); message.setText("PFA");
		 * 
		 * MimeBodyPart messageBodyPart = new MimeBodyPart();
		 * 
		 * Multipart multipart = new MimeMultipart();
		 * 
		 * messageBodyPart = new MimeBodyPart(); String file =
		 * "C:\\Work\\JibeTesting\\test-output\\emailable-report.html"; String
		 * fileName = "emailable-report.html"; DataSource source = new
		 * FileDataSource(file); messageBodyPart.setDataHandler(new
		 * DataHandler(source)); messageBodyPart.setFileName(fileName);
		 * multipart.addBodyPart(messageBodyPart);
		 * 
		 * message.setContent(multipart);
		 * 
		 * System.out.println("Sending");
		 * 
		 * Transport.send(message);
		 * 
		 * System.out.println("Done");
		 * 
		 * } catch (MessagingException e) { e.printStackTrace(); }
		 */
	}

}
