package model;

public class exercise {
    private String id;
    private String day;
    private int image;


    public exercise(String id,String day, int image) {
        this.id = id;
        this.day = day;
        this.image = image;
    }

    public String getId() {
        return id;
    }
    public String getDay() {
        return day;
    }


    public int getImage() {
        return image;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setDay(String day) {
        this.day = day;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "exercise{" +
                "day='" + day + '\'' +
                '}';
    }
}
