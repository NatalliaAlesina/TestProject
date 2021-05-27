package driver;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Synchronized;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BrowserSettings {

    private Browsers browsers;

    private static BrowserSettings instance;

    @Synchronized
    public static BrowserSettings getInstance() {
        if (instance == null) {
            instance = new BrowserSettings();
        }
        return instance;
    }
}