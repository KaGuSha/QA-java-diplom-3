package api.users;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

@Data
public class User {
    private String email;
    private String password;
    private String name;

    public User(String email, String password,String name) {
        this.email = email;
        this.password = password;
        this.name =name;
    }

    public static User getRandomUser() {
        String email = RandomStringUtils.randomAlphanumeric(10)+"@test.test";
        String password = RandomStringUtils.randomAlphanumeric(8);
        String name = RandomStringUtils.randomAlphabetic(15);

        return new User(email,password,name);
    }

    public static User getUser1 () {
        return new User ("mariatest202206@test.test", "Maria2022test","Мария");
    }

    public static User getUserPass5 () {
        return new User ("mariatest202206@test.test","Maria", "Мария");
    }


}
