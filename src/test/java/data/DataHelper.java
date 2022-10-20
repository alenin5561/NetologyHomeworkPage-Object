package data;

import lombok.Value;

public class DataHelper {

    private DataHelper() {
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    public static AuthInfo getOtherAuthInfo(AuthInfo original) {
        return new AuthInfo("petya", "123qwerty");
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    public static TransferCard getCardInfo() {

        return new TransferCard("5559000000000002");
    }

    public static TransferCard getNewCardInfo() {

        return new TransferCard("5559000000000001");
    }

    public static CardId getCardIdInfo() {

        return new CardId("92df3f1c-a033-48e6-8390-206f6b1f56c0");
    }

    public static CardId getNewCardIdInfo() {

        return new CardId("0f3f5c2a-249e-4c3d-8287-09f7a039391d");
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    @Value
    public static class TransferCard {
        private String cardNumber;
    }

    @Value
    public static class CardId {
        private String cardId;
    }


}