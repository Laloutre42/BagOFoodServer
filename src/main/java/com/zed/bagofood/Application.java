package com.zed.bagofood;

/**
 * Created by Arnaud on 30/04/2015.
 */

import com.zed.bagofood.model.Product;
import com.zed.bagofood.repository.FoodListRepository;
import com.zed.bagofood.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FoodListRepository foodListRepository;

    /**
     * Class Logger
     */
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        insertDataFromCiqualCsv();
        // users
//        User maurice = new User("Maurice", "Maurice@gmail.com");
//        User arnaud = new User("Arnaud", "Arnaud@gmail.com");
//
//        // save a couple of user
//        userRepository.save(maurice);
//        userRepository.save(arnaud);

        // items
//        Item item1 = new Item("item1", Category.BREAKFAST, 15, 30);
//        Item item2 = new Item("item2", Category.LUNCH, 445, 32);
//        Item item3 = new Item("item3", Category.BREAKFAST, 323, 43214);
//        Item item4 = new Item("item4", Category.SNACK, 4324, 324599);
//
//        itemRepository.save(item1);
//        itemRepository.save(item2);
//        itemRepository.save(item3);
//        itemRepository.save(item4);

        // food list
//        Foodlist foodList1 = new Foodlist(arnaud, "Liste 1", "Descttisifodfisn,");
//        Foodlist foodList2 = new Foodlist(arnaud, "Liste 2", "qsdklqdkqsklmqdmlsm");
//        Foodlist foodList3 = new Foodlist(maurice, "Liste 1", "kfjdskjfd^s");
//
//        foodList1.getItemList().add(item1);
//        foodList1.getItemList().add(item2);
//        foodList1.getItemList().add(item3);
//        foodList1.getItemList().add(item4);
//
//        foodList3.getItemList().add(item1);
//        foodList3.getItemList().add(item2);
//
//        // save a couple of food list
//        foodListRepository.save(foodList1);
//        foodListRepository.save(foodList2);
//        foodListRepository.save(foodList3);
//
//        logger.info(foodListRepository.findAll().toString());
//        logger.info(foodListRepository.findByUser_Id(1).toString());
    }

    private void insertDataFromCiqualCsv() {

        Path path = Paths.get("F:/DEV/ProjectJs/BagOFoodGulp/data/Ciqual_2012/input.csv");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            List<String> list = Arrays.asList(reader.readLine().split(","));
            Product product = new Product();

            logger.info(list.get(0));

            product.setOriggpcd(Integer.parseInt(list.get(0)));
            product.setOriggpfr(list.get(1));
            product.setOrigfdcd(Integer.parseInt(list.get(2)));
            product.setOrigfdnm(list.get(3));

//            private double sodium_mg_100g;
//            private double magnesium_mg_100g;
//            private double phosphore_mg_100g;
//            private double potassium_mg_100g;
//            private double calcium_mg_100g;
//            private double manganese_mg_100g;
//            private double fer_mg_100g;
//            private double cuivre_mg_100g;
//            private double zinc_mg_100g;
//            private double selenium_µg_100g;
//            private double iode_µg_100g;
//            private double proteines_g_100g;
//            private double proteines_brutes_n_x_6_25_g_100g;
//            private double glucides_g_100g;
//            private double sucres_g_100g;
//            private double energie_reglement_ue_1169_2011_kj_100g;
//            private double energie_reglement_ue_1169_2011_kcal_100g;
//            private double amidon_g_100g;
//            private double energie_n_x_facteur_jones_avec_fibres_kj_100g;
//            private double energie_n_x_facteur_jones_avec_fibres_kcal_100g;
//            private double polyols_totaux_g_100g;
//            private double fibres_g_100g;
//            private double eau_g_100g;
//            private double lipides_g_100g;
//            private double ag_satures_g_100g;
//            private double ag_monoinsatures_g_100g;
//            private double ag_polyinsatures_g_100g;
//            private double ag_4_0_butyrique_g_100g;
//            private double ag_6_0_caproïque_g_100g;
//            private double ag_8_0_caprylique_g_100g;
//            private double ag_10_0_caprique_g_100g;
//            private double ag_12_0_laurique_g_100g;
//            private double ag_14_0_myristique_g_100g;
//            private double ag_16_0_palmitique_g_100g;
//            private double ag_18_0_stearique_g_100g;
//            private double ag_18_1_9c_n_9_oleique_g_100g;
//            private double ag_18_2_9c_12c_n_6_linoleique_g_100g;
//            private double ag_18_3_c9_c12_c15_n_3_alpha_linolenique_g_100g;
//            private double ag_20_4_5c_8c_11c_14c_n_6_arachidonique_g_100g;
//            private double ag_20_5_5c_8c_11c_14c_17c_n_3_epa_g_100g;
//            private double ag_22_6_4c_7c_10c_13c_16c_19c_n_3_dha_g_100g;
//            private double retinol_µg_100g;
//            private double beta_carotene_µg_100g;
//            private double vitamine_d_µg_100g;
//            private double vitamine_e_mg_100g;
//            private double vitamine_k_µg_100g;
//            private double vitamine_c_mg_100g;
//            private double vitamine_b1_ou_thiamine_mg_100g;
//            private double vitamine_b2_ou_riboflavine_mg_100g;
//            private double vitamine_b3_ou_pp_ou_niacine_mg_100g;
//            private double vitamine_b5_ou_acide_pantothenique_mg_100g;
//            private double vitamine_b6_mg_100g;
//            private double vitamine_b12_µg_100g;
//            private double vitamine_b9_ou_folates_totaux_µg_100g;
//            private double alcool_g_100g;
//            private double acides_organiques_g_100g;
//            private double cholesterol_mg_100g;

            logger.info(product.toString());
        }
        catch (IOException e) {
            logger.error("IOException", e);
        }
    }

}
