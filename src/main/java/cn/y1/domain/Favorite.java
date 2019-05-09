package cn.y1.domain;

public class Favorite {
    private Purchase purchase;
    private String date;
    private  User user;

    public Favorite() {
    }

    public Favorite(Purchase purchase, String date, User user) {
        this.purchase = purchase;
        this.date = date;
        this.user = user;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
