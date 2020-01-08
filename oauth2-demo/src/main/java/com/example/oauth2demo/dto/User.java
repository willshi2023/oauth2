package com.example.oauth2demo.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

@Setter
public class User {
    private String id;
    private String username;
    @NotBlank
    private String password;
    @Past
    private Date birthDay;
    public interface UserSimpleView{};
    public interface UserDetailView extends UserSimpleView{};

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }

    @JsonView(UserSimpleView.class)
    public Date getBirthDay() {
        return birthDay;
    }

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }
}
