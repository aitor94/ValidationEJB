package server;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtilities 
{
	private MimeMessage message;
	private Session session;
	private Properties props;
	private InternetAddress from;
	private Transport transport;
	
	public EmailUtilities()
	{
		props = System.getProperties();
	    props.put("mail.smtp.starttls.enable", true); // added this line
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.user","amigoinvisibl3.rocketind@gmail.com");
	    props.put("mail.smtp.password","SNzme8a.(yup");
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.auth", true);

	    session = Session.getInstance(props,null);
	    
	    try {
			transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com","amigoinvisibl3.rocketind@gmail.com","SNzme8a.(yup");
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public void setMessage(String destination,String contenido)
	{
		try {
			message = new MimeMessage(session);
			
			from = new InternetAddress("amigoinvisibl3.rocketind@gmail.com");
			
			message.setSubject("Registro XMPP");//es
	        message.setFrom(from);//es
	        message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(destination));//es
	        message.setContent(contenido, "text/html");//es
		} 
		catch (AddressException e) {
			
			e.printStackTrace();
		} 
		catch (MessagingException e) {
			
			e.printStackTrace();
		}
	}
	
	public boolean enviaCorreo()
	{
		try {
			transport.sendMessage(message, message.getAllRecipients());
			return true;
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
}
