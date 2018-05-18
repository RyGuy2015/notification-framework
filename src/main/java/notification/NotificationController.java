package notification;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
	

	public static final String ACCOUNT_SID = "ACb5fd79f1a5d0870f7748f7570d6b3cbe";
	public static final String AUTH_TOKEN = "cf18f5d7550b3bbcf36216caa98b1db6";
	

    private static final String template = "Holy Shit! It's an %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/sms")
    public Notification sms(@RequestParam(value="name", defaultValue="SMS") String name) {
        return new Notification(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/email")
    public Notification email(@RequestParam(value="name", defaultValue="Email") String name) {
        return new Notification(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
