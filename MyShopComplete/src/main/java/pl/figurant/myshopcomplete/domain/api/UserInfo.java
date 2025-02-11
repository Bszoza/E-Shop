package pl.figurant.myshopcomplete.domain.api;

import java.sql.Date;

public class UserInfo {
    private String name;
    private String lastName;
    private String email;
    private String username;
    private Date registrationDate;

    public UserInfo(String name, String lastName, String email, String username, Date registrationDate) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.registrationDate = registrationDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}

