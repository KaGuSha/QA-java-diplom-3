package api.users;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
public class User {
    private String name;
    private String email;
    private String password;

    public User(String name,String email, String password) {
        this.name =name;
        this.email = email;
        this.password = password;
    }

    public static User getRandomUser() {
        String name = RandomStringUtils.randomAlphabetic(15);
        String email = RandomStringUtils.randomAlphanumeric(10)+"@test.test";
        String password = RandomStringUtils.randomAlphanumeric(8);

        return new User(name,email,password);
    }

    public static User getUser1 () {
        return new User ("Мария","mariatest202206@test.test", "Maria2022test");
    }

    public static User getUserPass5 () {
        return new User ("Мария","mariatest202206@test.test", "Maria");
    }


}
