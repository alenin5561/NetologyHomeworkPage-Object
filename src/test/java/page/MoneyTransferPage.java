package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class MoneyTransferPage {
    private SelenideElement amountField = $("[data-test-id=amount] input");
    private SelenideElement fromField = $("[data-test-id=from] input");
    private SelenideElement transferButton = $("[data-test-id=action-transfer]");

   /* public VerificationPage transferMoney(DataHelper.Balance info) {
        amountField.setValue(info.getCardNumber());
        fromField.setValue(info.getAmount());
        transferButton.click();
        return new VerificationPage();
    }
    */

}
