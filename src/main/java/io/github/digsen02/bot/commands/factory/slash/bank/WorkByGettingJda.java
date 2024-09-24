package io.github.digsen02.bot.commands.factory.slash.bank;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class WorkByGettingJda {
    private JDA jda;

    public WorkByGettingJda(JDA jda) {
        this.jda = jda;
    }

    public CompletableFuture<String> getMemberNickNameIfUserNickNameSameInput(String userInputUserName, String serverId) {
        Guild guild = jda.getGuildById(serverId);
        CompletableFuture<String> futureResult = new CompletableFuture<>();
        Objects.requireNonNull(guild).loadMembers().onSuccess(members -> {
            for (Member member : members) {
                String getMemberName = member.getUser().getName();
                String getMemberNickName = member.getUser().getEffectiveName();
                if (userInputUserName.equals(getMemberNickName) || userInputUserName.equals(getMemberName)) {
                    futureResult.complete(getMemberNickName + ":" + getMemberName);
                }
            }
            futureResult.complete("error");
        }).onError(futureResult::completeExceptionally);
        return futureResult;
    }

    public CompletableFuture<String> getUserIdIfUserNickNameSameInput(String userInputUserName, String serverId) {
        Guild guild = jda.getGuildById(serverId);
        CompletableFuture<String> futureResult = new CompletableFuture<>();
        Objects.requireNonNull(guild).loadMembers().onSuccess(members -> {
            for (Member member : members) {
                String getMemberName = member.getUser().getName();
                String getMemberNickName = member.getUser().getEffectiveName();
                String getMemberId = member.getUser().getId();
                System.out.println(getMemberId);
                if (userInputUserName.equals(getMemberNickName) || userInputUserName.equals(getMemberName)) {
                    futureResult.complete(getMemberId);
                }
            }
            futureResult.complete("error");
        }).onError(futureResult::completeExceptionally);

        System.out.println(futureResult + "{}");
        return futureResult;
    }
}
