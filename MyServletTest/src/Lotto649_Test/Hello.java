package Lotto649_Test;

import java.util.*;

public class Hello {
	
	private Map<String, String> messages; 
	
	public Hello() {
		messages = new HashMap<String, String>();
		messages.put("�f�f", "Hello");
		messages.put("����", "Welcome");
		messages.put("����", "Hi"); 
	}
	
	public String doHead(String user) {
		 String message = messages.get(user);
		 return message + ", " + user + "!";
		 } 
}
