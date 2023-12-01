package com.matdb.enums;

public enum DBEnum {

    DB_TEMPLATE_SAVE_SUCCESS("The template is saved successfully."),

    DB_TEMPLATE_SAVE_ERROR("Template saving failure."),

    DB_CARD_NOT_FOUND("The card does not exist."),

    DB_CARD_UPDATE_SUCCESS("card updated successful."),

    DB_CARD_UPDATE_ERROR("card update failure."),

    DB_BURN_SUCCESS("Burn out."),

    DB_BURN_ERROR("Error when burning.");


    private final String message;

    DBEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
