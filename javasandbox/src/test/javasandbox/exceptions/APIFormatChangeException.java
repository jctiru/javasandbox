package test.javasandbox.exceptions;

public class APIFormatChangeException extends Exception {
	private String response;
	private String elementName;
	private String partner;

	public APIFormatChangeException(String response, String elementName, String partner) {
		super("Response: " + response + ", Element: " + elementName + ", Partner: " + partner);
		this.response = response;
		this.elementName = elementName;
		this.partner = partner;
	}
	
//	public APIFormatChangeException(String response, String elementName, String partner, Throwable cause) {
//		super("Response: " + response + ", Element: " + elementName + ", Partner: " + partner, cause);
//		this.response = response;
//		this.elementName = elementName;
//		this.partner = partner;
//	}

	/*
	 * public APIFormatChangeException(String message) { super(message); }
	 */

	public String getResponse() {
		return response;
	}

	public String getElementName() {
		return elementName;
	}

	public String getPartner() {
		return partner;
	}
}
