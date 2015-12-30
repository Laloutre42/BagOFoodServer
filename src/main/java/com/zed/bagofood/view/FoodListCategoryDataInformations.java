package com.zed.bagofood.view;

import lombok.Data;

/**
 * Created by Arnaud on 07/11/2015.
 */
@Data
public class FoodListCategoryDataInformations {

    private int totalWeight = 0;
    private float totalEnergy = 0;
    private float totalEnergy100g = 0;
    private float averagelEnergy100g = 0;
    private int nbItems = 0;
    private String category;

    public FoodListCategoryDataInformations(String category){
        this.category = category;
    }

}
