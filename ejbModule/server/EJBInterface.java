package server;

import javax.ejb.Remote;

@Remote
public interface EJBInterface 
{
	public String sendEmail(String destination);
	public boolean validateEmail(String email);
}
