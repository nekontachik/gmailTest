package com.home.gmail.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class Gmail {


    public static void visit(){
        open("https://gmail.com");
    }

    public static void login(String email, String password) {
        $("#Email").setValue(email);
        $("#next").click();
        $("#Passwd").setValue(password);
        $("#signIn").click();
    }
}
