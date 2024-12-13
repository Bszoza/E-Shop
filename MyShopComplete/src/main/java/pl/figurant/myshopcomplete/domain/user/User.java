package pl.figurant.myshopcomplete.domain.user;

import java.time.LocalDateTime;

public class User {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String username;
    private LocalDateTime registrationDate;

    public User(String name, String lastName, String email, String password, String username, LocalDateTime registrationDate) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.username = username;
        this.registrationDate = registrationDate;
    }//brak id bo id nadaje baza danych

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }
}
