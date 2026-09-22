import java.util.Date;

public class Session {
    private String username;
    private String name;
    private Date loginTime;

    public Session(String username, String name, Date loginTime) {
        this.username = username;
        this.name = name;
        this.loginTime = loginTime;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public Date getLoginTime() {
        return loginTime;
    }
}
