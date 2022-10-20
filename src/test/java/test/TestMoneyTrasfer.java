package test;

import data.DataHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.MoneyTransferPage;

import static com.codeborne.selenide.Selenide.*;

public class TestMoneyTrasfer {

    @Test
    void shouldTransferMoneyFromCard1() {
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify((verificationCode));
        dashboardPage.addMoneyToFirstCard();
        var moneyTransferPage = new MoneyTransferPage();
        var transferInfo = DataHelper.getCardInfo();
        $("[data-test-id=amount] input").setValue("0");
        var transferPage = moneyTransferPage.transferMoney(transferInfo);
        var actual = dashboardPage.getFirstCardBalance();
        var expected = ();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void shouldTransferMoneyFromCard2() {
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify((verificationCode));
        dashboardPage.addMoneyToSecondCard();
        var moneyTransferPage = new MoneyTransferPage();
        var transferInfo = DataHelper.getNewCardInfo();
        $("[data-test-id=amount] input").setValue("10000");
        var transferPage = moneyTransferPage.transferMoney(transferInfo);
        var actual = dashboardPage.getFirstCardBalance();
        var expected = ();
        Assertions.assertEquals(expected,actual);
    }
}


