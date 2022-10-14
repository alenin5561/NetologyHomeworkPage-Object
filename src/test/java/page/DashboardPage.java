package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.ArrayList;
import java.util.List;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");

    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public List<String> getCards() {
        //    return $$("ul li[class=list__item] div")
        //           .stream().map(it -> it.getAttribute("data-test-id"))
        //                          .collect(Collectors.toList());
        //        }
        ElementsCollection cardElements = $$("ul li[class=list__item] div");
        List<String> cards = new ArrayList<>();

        for (SelenideElement card : cardElements) {
            cards.add(card.getAttribute("data-test-id"));
        }
        return cards;
    }

    public String getCardBalance(String cardId){
       return  $(String.format("div[data-test-id='%s']",cardId)).getOwnText();
    }

    public void addMoneyToCard(String cardId){
        $(String.format("div[data-test-id='%s']",cardId)).$("button").click();
    }



}