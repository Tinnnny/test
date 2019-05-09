package cn.y1.domain;

public class News {
    private int id;
    private String date;
    private String des ;
    private String image;

    public News() {
    }

    public News(int id, String date, String des, String image) {
        this.id = id;
        this.date = date;
        this.des = des;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
