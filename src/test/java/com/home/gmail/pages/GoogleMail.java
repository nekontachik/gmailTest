package com.home.gmail.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class GoogleMail {

    static ElementsCollection mails = $$(".aDP tbody tr");

     public static void login(String email, String password){
        $("#Email").setValue(email);
        $("#next").click();
        $("#Passwd").setValue(password);
        $("#signIn").click();
    }


    public static void send(String address, String subject){
        $(byText("COMPOSE")).click();
        $(byName("to")).setValue(address).pressTab();
        $(byName("subjectbox")).setValue(subject);
        $(byText("Send")).click();
    }


    public static void refresh() {
        $(".asf").click();
    }

    public  static void assertMailInInbox(int index, String mailHeaderText){
      mails.get(index).shouldHave(text(mailHeaderText));
    }

    public static void openSent() {
        $(byTitle("Sent Mail")).click();
    }

    public static void openInbox() {
        $(byTitle("Inbox")).click();
    }

    public static void assertMailInSent(int index, String mailHeaderText) {
        mails.get(index).shouldHave(text(mailHeaderText));
    }

    public static void searchMail(String subject) {
        $(byName("q")).setValue(subject).pressEnter();
    }

    public static void assertMailInSearchList(int mailsCount, String mailSubjectTexts) {
            $$(mails).shouldHave(texts(mailSubjectTexts)).shouldHaveSize(mailsCount).shouldHave(texts(mailSubjectTexts));
    }
}
