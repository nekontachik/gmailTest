package com.home.gmail.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class GoogleMail {

    static ElementsCollection mails = $$("[role=\"main\"]");

    public static void login(String email, String password) {
        $("#Email").setValue(email);
        $("#next").click();
        $("#Passwd").setValue(password);
        $("#signIn").click();
    }

    public static void send(String address, String subject) {
        $(byText("COMPOSE")).click();
        $(byName("to")).setValue(address).pressTab();
        $(byName("subjectbox")).setValue(subject);
        $(byText("Send")).click();
    }

    public static void refresh() {
        $(".asf").click();
    }

    public static void openSent() {
        $(byTitle("Sent Mail")).click();
    }

    public static void openInbox() {
        back();
    }

    public static void assertMail(int index, String mailHeaderText) {
        mails.get(index).shouldHave(text(mailHeaderText));
    }

    public static void searchMail(String queryText) {
        $(byName("q")).setValue(queryText).pressEnter();
    }

    public static void assertSearchResults(String... mailSubjectTexts) {
        $$("[role=\"main\"] div>span>b").shouldHave(texts(mailSubjectTexts));
    }
}
