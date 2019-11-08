package com.szps.web.domain.event;

public class WeChatUser {
    private  String  userName;
    private  String passWord;



    public WeChatUser(String username, String password) {
        this.userName = username;
        this.passWord = password;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return passWord;
    }

    public void setPassword(String password) {
        this.passWord = password;
    }
}
