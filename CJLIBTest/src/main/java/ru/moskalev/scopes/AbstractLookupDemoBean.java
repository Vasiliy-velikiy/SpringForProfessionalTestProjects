package ru.moskalev.scopes;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * Внедрение в бин singlton бина  singer с областью prototype
 * Данный метод внедрения называется Внедрение зависимостей через метод поиска
 * используются возможности библиотеки CGLIВ для динамическоm расширения байт-кода.
 */
@Component("abstractLookupBean")
public class AbstractLookupDemoBean implements DemoBean {

    @Lookup("singer")
    @Override
    public Singer getMySinger() {
        return null;
    }

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
