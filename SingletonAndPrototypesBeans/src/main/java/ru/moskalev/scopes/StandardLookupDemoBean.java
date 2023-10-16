package ru.moskalev.scopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * при внедрении через метод установки , бин Singer все равно будет singleton
 */
@Component("standardLookupBean")
public class StandardLookupDemoBean implements DemoBean {

    private Singer mySinger;

    @Autowired
    @Qualifier("singer")
    public void setMySinger(Singer mySinger) {
        this.mySinger = mySinger;
    }

    @Override
    public Singer getMySinger() {
        return this.mySinger;
    }

    @Override
    public void doSomething() {
        this.mySinger.sing();
    }
}
