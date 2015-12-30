package com.zed.bagofood.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zed.bagofood.model.Foodlist;

/**
 * Created by Arnaud on 07/11/2015.
 */
public class FoodListDataInformations {

    private Map<String, FoodListCategoryDataInformations> categoryDataInformationsMap = new HashMap();

    public FoodListDataInformations(Foodlist foodlist) {
        computeInformationsFromFoodList(foodlist);
    }

    /**
     * Iterate over foodlist items and return sum or average for each category (informations)
     *
     * @param foodlist
     */
    private void computeInformationsFromFoodList(Foodlist foodlist) {

    	// TODO
//        if (foodlist != null) {
//
//            List<Item> items = foodlist.getItemList();
//
//            if (!items.equals(null)) {
//
//
//                FoodListCategoryDataInformations foodListAllDataInformations = new FoodListCategoryDataInformations("All");
//                for (Item item : items) {
//
//                    FoodListCategoryDataInformations foodListCategoryDataInformations;
//                    if (item.getCategory() != null && categoryDataInformationsMap.containsKey(item.getCategory())) {
//                        foodListCategoryDataInformations = categoryDataInformationsMap.get(item.getCategory());
//                    } else {
//                        foodListCategoryDataInformations = new FoodListCategoryDataInformations(item.getCategory());
//                    }
//
//                    // Compute for item category
//                    addValuesFromItem(foodListCategoryDataInformations, item);
//                    // Compute for all categories
//                    addValuesFromItem(foodListAllDataInformations, item);
//
//                    categoryDataInformationsMap.put(item.getCategory(), foodListCategoryDataInformations);
//                }
//                categoryDataInformationsMap.put(foodListAllDataInformations.getCategory(), foodListAllDataInformations);
//            }
//        }
    }

    /**
     * Return foodlist informations on each category
     * @return
     */
    public Collection<FoodListCategoryDataInformations> statisticsTable() {
        return categoryDataInformationsMap.values();
    }

    public Map<String, List<Object>> statisticsChartHisto() {

        Map<String, List<Object>> result = new HashMap<>();
        result.put("totalWeight", new ArrayList<>());
        result.put("totalEnergy", new ArrayList<>());
        result.put("averagelEnergy100g", new ArrayList<>());
        result.put("category", new ArrayList<>());

        categoryDataInformationsMap.forEach((s, f) -> {
            result.get("totalWeight").add(f.getTotalWeight());
            result.get("totalEnergy").add(f.getTotalEnergy());
            result.get("averagelEnergy100g").add(f.getAveragelEnergy100g());
            result.get("category").add(f.getCategory());
        });
        return result;
    }

    // TODO
//    public static void addValuesFromItem(FoodListCategoryDataInformations foodListCategoryDataInformations, Item item) {
//        foodListCategoryDataInformations.setTotalWeight(foodListCategoryDataInformations.getTotalWeight() + item.getWeight());
//        foodListCategoryDataInformations.setTotalEnergy(foodListCategoryDataInformations.getTotalEnergy() + (item.getWeight() * item.getEnergyFor100() / 100));
//        foodListCategoryDataInformations.setTotalEnergy100g(foodListCategoryDataInformations.getTotalEnergy100g() + item.getEnergyFor100());
//        foodListCategoryDataInformations.setNbItems(foodListCategoryDataInformations.getNbItems() + 1);
//        foodListCategoryDataInformations.setAveragelEnergy100g(foodListCategoryDataInformations.getTotalEnergy100g() / foodListCategoryDataInformations.getNbItems());
//    }

}
