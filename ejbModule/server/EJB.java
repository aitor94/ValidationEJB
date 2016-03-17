package server;

import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class EJB implements EJBInterface
{

	@Override
	public String sendEmail(String destination) 
	{
		EmailUtilities eu = new EmailUtilities();
		
		Random rnd = new Random();
		int num= (100000 + rnd.nextInt(900000));
		
		
		eu.setMessage(destination, "Utilize este número para completar el registro->"+String.valueOf(num) );
		
		if(eu.enviaCorreo())
			return String.valueOf(num);
		else
			return null;
	}
	
	@Override
	public boolean validateEmail(String email)
	{
		return EmailValidator.validateEmail(email);
	}
	
}
