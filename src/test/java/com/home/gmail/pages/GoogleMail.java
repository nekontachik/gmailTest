package com.home.gmail.pages;

import com.codeborne.selenide.ElementsCollection;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Алексей on 21.11.2016.
 */
public class GoogleMail {

    static ElementsCollection letters = $$(".aDP tbody tr div>span>b");

     public static void mailLogin(String email, String password){
        $("#Email").setValue(email);
        $("#next").click();
        $("#Passwd").setValue(password);
        $("#signIn").click();
    }

    static String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());

    public static void sendMail(String address){
        $(byText("COMPOSE")).click();
        $(byName("to")).setValue(address).pressTab();
        $(byName("subjectbox")).setValue(timeStamp);
        $(byText("Send")).click();
    }


    public static void refresh() {
        $(".asf").click();
    }

    public  static void assertInInbox(String...timeStamps){
      letters.shouldHave(exactTexts(timeStamps));
    }

    public static void openSent() {
        $(byTitle("Sent Mail")).click();
    }

    public static void assertInSent() {
        letters.shouldHave(exactTexts(timeStamp));
    }

    public static void searchMail() {
        $(byName("q")).setValue(timeStamp).pressEnter();
    }

    public static void assertinSearch() {
            $$(byText(timeStamp)).filter(visible).shouldHave(exactTexts(timeStamp));
    }
}
