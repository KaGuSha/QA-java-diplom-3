package api.users;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserCredentials {
    private String email;
    private String password;

    public UserCredentials(@NonNull String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserCredentials(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public static UserCredentials from(User user) {
        return new UserCredentials(user);
    }

    @Override
    public String toString() {
        return "{ \"email\": \"" + email + "\",\"password\": \"" + password + "\"}";
    }
}


