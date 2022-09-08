package by.htp.cathelper.viewmodel;

import by.htp.cathelper.entity.User;

public class RequestViewModel {
    private int id;
    private int activeRequestAmount;
    private User requester;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActiveRequestAmount() {
        return activeRequestAmount;
    }

    public void setActiveRequestAmount(int activeRequestAmount) {
        this.activeRequestAmount = activeRequestAmount;
    }

    public User getRequester() {
        return requester;
    }

    public void setRequester(User requester) {
        this.requester = requester;
    }
}
