package com.matdb.enums;

public enum MatEnum {
    MAT_DELETE_SUCCESS("Delete it successfully."),

    MAT_DELETE_ERROR("fail to delete."),

    MAT_SAVE_SUCCESS("Save it successfully."),

    MAT_SAVE_ERROR("fail to save."),

    MAT_NOT_FOUND("It does not exist."),

    MAT_UPDATE_SUCCESS("Update it successfully."),

    MAT_UPDATE_ERROR("fail to update."),

    MAT_ADD_FILE_SUCCESS("Save the file successfully."),

    MAT_ADD_FILE_ERROR("fail to save the file.");

    private final String message;

    MatEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
