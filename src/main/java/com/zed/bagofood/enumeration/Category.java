package com.zed.bagofood.enumeration;

/**
 * Created by Arnaud on 03/05/2015.
 */
public enum Category {

    BREAKFAST("BREAKFAST"),
    SNACK("SNACK"),
    LUNCH("LUNCH"),
    DINER("DINER")
    ;

    private String category;

    private Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }
}
