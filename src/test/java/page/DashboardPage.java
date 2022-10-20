package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private final ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    private final SelenideElement heading = $("[data-test-id=dashboard]");


    public DashboardPage() {
        heading.shouldBe(visible);
    }


    public String getFirstCardBalance() {
        return $("div[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']").getOwnText();
    }

    public String getSecondCardBalance() {
        return $("div[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']").getOwnText();
    }

    public void addMoneyToFirstCard() {
        $("div[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']").$("button").click();
    }

    public void addMoneyToSecondCard() {
        $("div[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']").$("button").click();
    }


}