package com.example.p3750852.conversation;

/**
 * Created by P3750852 on 2017.08.24..
 */

public class LoginModel {
    //  private Device device;
    private String email;
    private String password;

    public LoginModel() {
    }

    public LoginModel(Device device, String email, String password) {
        //   this.device = device;
        this.email = email;
        this.password = password;
    }

    //  public Device getDevice() {return device; }

    //  public void setDevice(Device device) {this.device = device;}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
