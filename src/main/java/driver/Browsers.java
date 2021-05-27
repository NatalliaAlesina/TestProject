package driver;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Browsers {
   //Test
    CHROME("CHROME"),
    FF("FF");

    private String name;
}
