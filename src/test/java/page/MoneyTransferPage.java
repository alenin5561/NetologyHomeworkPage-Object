package page;

import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class MoneyTransferPage {
    public DashboardPage transferMoney(DataHelper.TransferCard info, String amount) {
        $("[data-test-id=from] input").setValue(info.getCardNumber());
        $("[data-test-id=amount] input").setValue(amount);
        $("[data-test-id=action-transfer]").click();
        return new DashboardPage();
    }

}

