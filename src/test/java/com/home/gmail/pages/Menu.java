package com.home.gmail.pages;

import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;

public class Menu {

    public static void refresh() {
        $(".asf").click();
    }

    public static void goToInbox() {
        $("[title~=Inbox]").click();
    }

    public static void goToSent() {
        $(byTitle("Sent Mail")).click();
    }
}
