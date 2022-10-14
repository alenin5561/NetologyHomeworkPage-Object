package test;

import data.DataHelper;
import org.junit.jupiter.api.Test;
import page.LoginPage;
import page.MoneyTransferPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class TestMoneyTrasfer {

        @Test
        void shouldShowFirstCardBalance() {
            open("http://localhost:9999");
            var loginPage = new LoginPage();
//    var loginPage = open("http://localhost:9999", LoginPageV2.class);
            var authInfo = DataHelper.getAuthInfo();
            var verificationPage = loginPage.validLogin(authInfo);
            var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
            var dashboardPage = verificationPage.validVerify((verificationCode));
            List<String> cards = dashboardPage.getCards();
            System.out.println(dashboardPage.getCardBalance((cards.get(0))));
        }
    @Test
    void shouldShowSecondCardBalance() {
        open("http://localhost:9999");
        var loginPage = new LoginPage();
//    var loginPage = open("http://localhost:9999", LoginPageV2.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify((verificationCode));
        List<String> cards = dashboardPage.getCards();
        System.out.println(dashboardPage.getCardBalance((cards.get(1))));
    }

    @Test
    void shouldTransferMoneyFromCards1() {
        open("http://localhost:9999");
        var loginPage = new LoginPage();
//    var loginPage = open("http://localhost:9999", LoginPageV2.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify((verificationCode));
        List<String> cards = dashboardPage.getCards();
         dashboardPage.addMoneyToCard("92df3f1c-a033-48e6-8390-206f6b1f56c0");
        var moneyTransferPage = new MoneyTransferPage();
        var transferInfo = DataHelper.getCardInfo();
        var transferPage = moneyTransferPage.transferMoney(transferInfo);
    }

    @Test
    void shouldTransferMoneyFromCards2() {
        open("http://localhost:9999");
        var loginPage = new LoginPage();
//    var loginPage = open("http://localhost:9999", LoginPageV2.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verificationPage.validVerify((verificationCode));
        List<String> cards = dashboardPage.getCards();
        dashboardPage.addMoneyToCard("0f3f5c2a-249e-4c3d-8287-09f7a039391d");
        var moneyTransferPage = new MoneyTransferPage();
        var transferInfo = DataHelper.getNewCardInfo();
        var transferPage = moneyTransferPage.transferMoney(transferInfo);
    }

}


