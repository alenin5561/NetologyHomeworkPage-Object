package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class MoneyTransferPage {
    private SelenideElement amountField = $("[data-test-id=amount] input");
    private SelenideElement fromField = $("[data-test-id=from] input");
    private SelenideElement transferButton = $("[data-test-id=action-transfer]");

    public int setAmount(int amount){
        return amount;
    }
    public DashboardPage transferMoney(DataHelper.TransferCard info) {
        amountField.setValue(setAmount);
        transferButton.click(info.getCardNumber());
        return new DashboardPage();
    }

}
