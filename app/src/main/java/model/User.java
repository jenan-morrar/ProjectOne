package model;

public class User {

    private String userName;
    private String password;
    private String email;
    private int age;

    public User(String userName, String password, String email, int age) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
