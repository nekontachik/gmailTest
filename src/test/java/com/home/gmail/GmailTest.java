package com.home.gmail;

import com.codeborne.selenide.Configuration;
import com.home.gmail.pages.Gmail;
import com.home.gmail.pages.Mails;
import com.home.gmail.pages.Menu;
import com.home.gmail.testconfigs.TestData;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GmailTest {
    @Before
    public void setTimeout() {
        Configuration.timeout = 30000;
    }

    @Test
    public void testEmailFlow() {

        Gmail.visit();
        Gmail.login(TestData.email, TestData.password);

        String subject = "subject" +
                new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());

        Mails.send(TestData.email, subject);

        Menu.refresh();
        Mails.assertMail(0, subject);

        Menu.goToSent();
        Mails.assertMail(0, subject);

        Menu.goToInbox();
        Mails.search(subject);

        Mails.assertMails(subject);
    }
}