package notification;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
public class NotificationController {
	

	public static final String ACCOUNT_SID = "ACb5fd79f1a5d0870f7748f7570d6b3cbe";
	public static final String AUTH_TOKEN = "cf18f5d7550b3bbcf36216caa98b1db6";
	

    private static final String template = "Holy Shit! You texted %s!";
    private final AtomicLong counter = new AtomicLong();

    
    @RequestMapping("/sms")
    public Notification sms(@RequestParam(value="number", defaultValue="7655324011") String number, 
    		@RequestParam(value="message", defaultValue="Your shit is broke yo!") String message) {
    	SendSMS(number, message);
        return new Notification(counter.incrementAndGet(),
                            String.format(template, number), String.format(message));
    }
    
    private void SendSMS(String num, String text) {	
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message.creator(
		new PhoneNumber("+1" + num),
		new PhoneNumber("+13173420844"),
		text).create();
	}

	@RequestMapping("/email")
    public Notification email(@RequestParam(value="number", defaultValue="7655324011") String number, 
    		@RequestParam(value="message", defaultValue="Your shit is broke yo!") String message) {
        return new Notification(counter.incrementAndGet(),
                            String.format(template, number), message);
    }

    
}
