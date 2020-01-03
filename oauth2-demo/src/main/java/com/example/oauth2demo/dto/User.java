package com.example.oauth2demo.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.Setter;

@Setter
public class User {
    private String id;
    private String username;
    private String password;
    public interface UserSimpleView{};
    public interface UserDetailView extends UserSimpleView{};

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }
}
