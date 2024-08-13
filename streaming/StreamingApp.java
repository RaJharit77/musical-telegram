package streaming.streaming;

import java.util.List;

/**
 * Note : c'est l'application elle-même, avec un ensemble d'utilisateurs de départ.
 */
public class StreamingApp {
    private List<User> allUsers;

    public StreamingApp(List<User> allUsers) {
        this.allUsers = allUsers;
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }

    @Override
    public String toString() {
        return "StreamingApp{" +
                "allUsers=" + allUsers +
                '}';
    }
}
