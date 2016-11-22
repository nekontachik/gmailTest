package com.home.gmail;

import com.home.gmail.testconfigs.TestData;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.home.gmail.pages.GoogleMailPage.*;

/**
 * Created by Алексей on 21.11.2016.
 */
public class GoogleMailTest extends TestData {

    @Test
    public void openMailAndCheckHisWork () {
        open("https://gmail.com");

        mailLogin(TestData.mail,TestData.passwd);

        assertComposeButton();

        sendMail(TestData.mail, "Hello broz");

        refresh();

        assertInInbox("Hello broz");
        assertInSent("Hello broz");

        searchAndAssert("Hello broz");
    }
}
