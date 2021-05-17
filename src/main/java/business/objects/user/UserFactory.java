package business.objects.user;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserFactory {


    public static User getUser() {
        User user = new User();
        String email = getProperty("login");
        user.setEmail(email);

        String password = getProperty("password");
        user.setEmail(password);
        return user;
    }

    public static String getProperty(String property) {

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream ("credentials"));
        } catch (IOException e) {
            System.out.println("Property file could not be read");
        }
        return property;
    }

}
