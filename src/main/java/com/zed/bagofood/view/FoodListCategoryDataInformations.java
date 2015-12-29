package com.zed.bagofood.view;

import com.zed.bagofood.model.Foodlist;
import com.zed.bagofood.model.Item;
import lombok.Data;

import java.util.List;

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
