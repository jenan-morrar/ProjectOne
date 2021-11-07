package model;

public class User {

    private String userName;
    private String password;
    private String gender;
    private int age;

    public User(String userName, String password, String gender, int age) {
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
