package com.home.gmail;

import com.codeborne.selenide.Configuration;
import com.home.gmail.testconfigs.TestData;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.codeborne.selenide.Selenide.open;
import static com.home.gmail.pages.GoogleMail.*;

public class GoogleMailTest{
    @Before
    public void openMail(){
        Configuration.timeout = 30000;
    }

    @Test
    public void checkEmailFlow() {
        open("https://gmail.com");

        login(TestData.mail, TestData.password);

        String subjectTimeStamp = "subject"
                + new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());


        send(TestData.mail, subjectTimeStamp);

        refresh();

        assertMailInInbox(0, subjectTimeStamp);

        openSent();
        assertMailInSent(0, subjectTimeStamp);

        openInbox();
        searchMail(subjectTimeStamp);
        assertMailInSearchList(1 , subjectTimeStamp);
    }
}
