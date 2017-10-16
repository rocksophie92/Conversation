package com.example.p3750852.conversation.models;


import com.example.p3750852.conversation.Device;

/**
 *
 * Created by Patrik on 2017. 04. 09..
 */

public class User {
    private String id;
    private String nick;
    private Location location;
    private Double distanceOut;
    private Double distanceIn;
    private String language;
    private String messageColor;
    private Boolean enableNotification;
    private String soundType;
    private String email;
    private String password;
    private String oldPassword;
    private String fbUserId;
    private String fbToken;
    private String fullName;
    private Device device;
    private String accessToken;
    private String renewToken;


    public void clearFields() {
        clearField(nick);
        clearField(language);
        clearField(messageColor);
        clearField(soundType);
        clearField(email);
        clearField(fullName);
    }

    private void clearField(String field) {
        if (field != null) {
            field = field.trim();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Double getDistanceOut() {
        return distanceOut;
    }

    public void setDistanceOut(Double distanceOut) {
        this.distanceOut = distanceOut;
    }

    public Double getDistanceIn() {
        return distanceIn;
    }

    public void setDistanceIn(Double distanceIn) {
        this.distanceIn = distanceIn;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMessageColor() {
        return messageColor;
    }

    public void setMessageColor(String messageColor) {
        this.messageColor = messageColor;
    }

    public Boolean getEnableNotification() {
        return enableNotification;
    }

    public void setEnableNotification(Boolean enableNotification) {
        this.enableNotification = enableNotification;
    }

    public String getSoundType() {
        return soundType;
    }

    public void setSoundType(String soundType) {
        this.soundType = soundType;
    }

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

    public String getFbUserId() {
        return fbUserId;
    }

    public void setFbUserId(String fbUserId) {
        this.fbUserId = fbUserId;
    }

    public String getFbToken() {
        return fbToken;
    }

    public void setFbToken(String fbToken) {
        this.fbToken = fbToken;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRenewToken() {
        return renewToken;
    }

    public void setRenewToken(String renewToken) {
        this.renewToken = renewToken;
    }

}
