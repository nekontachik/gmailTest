package com.home.gmail.pages;

import com.codeborne.selenide.ElementsCollection;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Mails {

    static ElementsCollection  mails = $$("[role=\"main\"] [role=\"link\"]");

    public static String subject = "subject" +
            new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());

    public static void send(String address, String subject) {
        $(byText("COMPOSE")).click();
        $(byName("to")).setValue(address).pressTab();
        $(byName("subjectbox")).setValue(subject);
        $(byText("Send")).click();
    }

    public static void assertMail(int index, String mailHeaderText) {
        mails.get(index).shouldHave(text(mailHeaderText));
    }

    public static void searchBySubject(String queryText) {
        $(byName("q")).setValue(queryText).pressEnter();
    }

    public static void assertMails(String... mailSubjectTexts) {
        mails.shouldHave(texts(mailSubjectTexts));
    }
}
