package io.github.digsen02.bot.bank;

public class AccountClassification {
    public String classifyAccount(String accounts) {
        String[] accountNum = accounts.split("-");
        return switch (accountNum[1]) {
            case "8734" -> "일반 계좌";
            case "3245" -> "주식 계좌";
            default -> "!에러: 계좌가 존재하지 않습니다! 봇 개발자에게 상황을 보고해주세요.";
        };
    }
}