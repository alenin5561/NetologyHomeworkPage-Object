package test;

import data.DataHelper;
import org.junit.jupiter.api.AfterEach;
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
        var firstCardBalance = dashboardPage.getFirstCardBalance();
        var secondCardBalance = dashboardPage.getSecondCardBalance();
        dashboardPage.addMoneyToFirstCard();
        var moneyTransferPage = new MoneyTransferPage();
        var transferInfo = DataHelper.getCardInfo();
        var amount = 1000;
        var transferPage = moneyTransferPage.transferMoney(transferInfo, String.valueOf(amount));
        var expectedFirstCardBalance = firstCardBalance + amount;
        var expectedSecondCardBalance = secondCardBalance - amount;
        var actualFirstCardBalance = dashboardPage.getFirstCardBalance();
        var actualSecondCardBalance = dashboardPage.getSecondCardBalance();
        Assertions.assertEquals(expectedFirstCardBalance, actualFirstCardBalance);
        Assertions.assertEquals(expectedSecondCardBalance, actualSecondCardBalance);
    }

    @Test
    void shouldTransferMoneyFromCard2() {
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify((verificationCode));
        var firstCardBalance = dashboardPage.getFirstCardBalance();
        var secondCardBalance = dashboardPage.getSecondCardBalance();
        dashboardPage.addMoneyToSecondCard();
        var moneyTransferPage = new MoneyTransferPage();
        var transferInfo = DataHelper.getNewCardInfo();
        var amount = 1000;
        var transferPage = moneyTransferPage.transferMoney(transferInfo, String.valueOf(amount));
        var expectedFirstCardBalance = firstCardBalance - amount;
        var expectedSecondCardBalance = secondCardBalance + amount;
        var actualFirstCardBalance = dashboardPage.getFirstCardBalance();
        var actualSecondCardBalance = dashboardPage.getSecondCardBalance();
        Assertions.assertEquals(expectedFirstCardBalance, actualFirstCardBalance);
        Assertions.assertEquals(expectedSecondCardBalance, actualSecondCardBalance);
    }
}



