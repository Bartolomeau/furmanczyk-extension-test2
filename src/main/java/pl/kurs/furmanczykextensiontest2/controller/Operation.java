package pl.kurs.furmanczykextensiontest2.controller;

public interface Operation<T>{

    String key();
    T getResponse();

}
