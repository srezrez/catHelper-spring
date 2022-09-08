package by.htp.cathelper.viewmodel;

import by.htp.cathelper.entity.Cat;

public class AddedCatViewModel {
    private Cat cat;
    private String age;
    private int activeRequestsAmount;

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getActiveRequestsAmount() {
        return activeRequestsAmount;
    }

    public void setActiveRequestsAmount(int activeRequestsAmount) {
        this.activeRequestsAmount = activeRequestsAmount;
    }
}
