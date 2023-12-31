package ru.moskalev.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("singer")
@Scope("prototype")
public class Singer {
    private String lyric = "I played а quick game of chess "
            + "with the salt and pepper shaker";

    public void sing() {
        System.out.println(lyric);
    }
}
