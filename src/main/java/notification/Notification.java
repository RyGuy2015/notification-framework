package notification;

public class Notification {

    private final long id;
    private final String number;
    private final String message;
    

    public Notification(long id, String number, String message) {
        this.id = id;
        this.number = number;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }
    
    public String getMessage() {
    	return message;
    }
    
    
}
