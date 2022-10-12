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


}


