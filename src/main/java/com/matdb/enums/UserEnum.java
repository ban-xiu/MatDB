package com.matdb.enums;

public enum UserEnum {
    SIGN_UP_SUCCESS("Sign up successful."),
    USERNAME_EXISTS("This username is already taken."),

    USER_NOT_FOUND("The user does not exist."),
    WRONG_PASSWORD("Wrong password."),
    LOGIN_SUCCESS("Login succeeded."),

    PASSWORD_CHANGED_SUCCESS("Password changed successfully."),
    PASSWORD_CHANGED_ERROR("Incorrect password change.");

    private final String message;

    UserEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
