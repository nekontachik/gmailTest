package com.home.gmail.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Алексей on 21.11.2016.
 */
public class GoogleMailPage {

    static SelenideElement composeButton = $(byText("COMPOSE"));

    public static void mailLogin(String email, String passwd){
        $("#Email").setValue(email);
        $("#next").click();
        $("#Passwd").setValue(passwd);
        $("#signIn").click();
    }


    public static void assertComposeButton() {
        composeButton.shouldHave(exactText("COMPOSE"));
    }

    public static void sendMail(String emailAddress, String emailSubject){
        composeButton.click();
        $(byName("to")).setValue(emailAddress).pressTab();
        $(byName("subjectbox")).setValue(emailSubject);
        $(byText("Send")).click();
    }

    public static void refresh() {
        $(byXpath("//div[2]/div[1]/div/div[1]/div[1]/div/div/div[4]/div")).click();
    }

    public  static void assertInInbox(String emailSubject){
        $(byText(emailSubject));
    }

    public static void assertInSent(String emailSubject) {
        $(byTitle("Sent Mail")).click();
        $(byName("me "));
        $(byText(emailSubject));
    }

    public static void searchAndAssert(String emailSubject) {
        $(byName("q")).setValue(emailSubject).pressEnter();
        $$(byText(emailSubject)).filter(visible).shouldHave(size(1));
    }
}
