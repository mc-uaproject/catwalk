package dev.ua.uaproject.catwalk.webhooks.models.events;

import com.google.gson.annotations.Expose;
import dev.ua.uaproject.catwalk.api.v1.models.Player;

public class PlayerQuitWebhookEvent extends WebhookEvent {
    @Expose
    Player player;

    @Expose
    String quitMessage;

    public PlayerQuitWebhookEvent() {
        eventType = EventType.PlayerQuit;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getQuitMessage() {
        return quitMessage;
    }

    public void setQuitMessage(String quitMessage) {
        this.quitMessage = quitMessage;
    }
}
