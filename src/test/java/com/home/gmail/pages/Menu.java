package com.home.gmail.pages;

import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;

public class Menu {

    public static void refresh() {
        $(".asf").click();
    }

    public static void goToInbox() {
        $("[href$=\"/mail/u/0/#inbox\"]").click();
    }

    public static void goToSent() {
        $(byTitle("Sent Mail")).click();
    }
}
