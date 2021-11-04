package model;

import android.widget.ImageView;

public class exercise {
    private String id;
    private String day;
    private String description;
    private int image;


    public exercise(String id,String day, String description, int image) {
        this.id = id;
        this.day = day;
        this.description = description;
        this.image = image;
    }

    public String getId() {
        return id;
    }
    public String getDay() {
        return day;
    }

    public String getDescription() {
        return description;
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

    public void setDescription(String description) {
        this.description = description;
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
