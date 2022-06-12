package framework.Components.Notification.Sms;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SmsMessage {
    private String to;
    private String body;
    
//	public SmsMessage(String to, String body) {
//		super();
//		this.to = to;
//		this.body = body;
//	}
	
	public String getTo() {
		return to;
	}
	public String getBody() {
		return body;
	}
    
    
}
