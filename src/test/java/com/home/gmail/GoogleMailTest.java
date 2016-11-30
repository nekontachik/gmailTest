package com.home.gmail;

import com.codeborne.selenide.Configuration;
import com.home.gmail.pages.Gmail;
import com.home.gmail.pages.Mails;
import com.home.gmail.pages.Menu;
import com.home.gmail.testconfigs.TestData;
import org.junit.Before;
import org.junit.Test;

import static com.home.gmail.pages.Mails.subject;

public class GoogleMailTest {
    @Before
    public void openMail() {
        Configuration.timeout = 30000;
    }

    @Test
    public void checkEmailFlow() {

        Gmail.visit();
        Gmail.login(TestData.email, TestData.password);

        Mails.send(TestData.email, subject);

        Menu.refresh();
        Mails.assertMail(0, subject);

        Menu.goToSent();
        Mails.assertMail(0, subject);

        Menu.goToInbox();
        Mails.searchBySubject(subject);

        Mails.assertMails(subject);
    }
}