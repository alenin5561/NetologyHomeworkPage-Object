package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class MoneyTransferPage {
    public DashboardPage transferMoney(DataHelper.TransferCard info) {
        $("[data-test-id=from] input").setValue(info.getCardNumber());
        $("[data-test-id=action-transfer]").click();
        return new DashboardPage();
    }

}

