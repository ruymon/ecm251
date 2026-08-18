import java.util.Date;
import java.util.UUID;

public class Session {
    private final UUID id;
    private final String name;
    private final String username;
    private final Date lastAccessedAt;

    public Session(UUID id, String name, String username, Date lastAccessedAt) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.lastAccessedAt = lastAccessedAt;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public Date getLastAccessedAt() {
        return lastAccessedAt;
    }
}
