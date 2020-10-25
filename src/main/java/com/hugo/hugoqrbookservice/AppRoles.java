package com.hugo.hugoqrbookservice;

public enum AppRoles {
    EDITOR ("editor"),
    GUEST ("guest");
    private final String role;
    AppRoles (String role){
        this.role = role;
    }
    public String value(){
        return this.role;
    }
}
