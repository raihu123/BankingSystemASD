package framework.core.notification.Sms;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SmsMessage {
    private String to;
    private String body;

	
	public String getTo() {
		return to;
	}
	public String getBody() {
		return body;
	}
    
    
}
