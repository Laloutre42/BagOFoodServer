package com.zed.bagofood.model.product;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

/**
 * Created by Arnaud on 18/05/2015.
 */
@Data
@Document
public class ProductCiqual {

    private final static String idDesignation = "Id";
    private final static String origgpcdDesignation = "ORIGGPCD";
    private final static String origgpfrDesignation = "ORIGGPFR";
    private final static String origfdcdDesignation = "ORIGFDCD";
    private final static String origfdnmDesignation = "ORIGGPFR";
    private final static String sodium_mg_100gDesignation = "ORIGGPFR";
    private final static String magnesium_mg_100gDesignation = "ORIGGPFR";
    private final static String phosphore_mg_100gDesignation = "ORIGGPFR";
    private final static String potassium_mg_100gDesignation = "ORIGGPFR";
    private final static String calcium_mg_100gDesignation = "ORIGGPFR";
    private final static String manganese_mg_100gDesignation = "ORIGGPFR";
    private final static String fer_mg_100gDesignation = "ORIGGPFR";
    private final static String cuivre_mg_100gDesignation = "ORIGGPFR";
    private final static String zinc_mg_100gDesignation = "ORIGGPFR";
    private final static String selenium_ug_100gDesignation = "ORIGGPFR";
    private final static String iode_ug_100gDesignation = "ORIGGPFR";
    private final static String proteines_g_100gDesignation = "ORIGGPFR";
    private final static String proteines_brutes_n_x_6_25_g_100gDesignation = "ORIGGPFR";
    private final static String glucides_g_100gDesignation = "ORIGGPFR";
    private final static String sucres_g_100gDesignation = "ORIGGPFR";
    private final static String energie_reglement_ue_1169_2011_kj_100gDesignation = "ORIGGPFR";
    private final static String energie_reglement_ue_1169_2011_kcal_100gDesignation = "ORIGGPFR";
    private final static String amidon_g_100gDesignation = "ORIGGPFR";
    private final static String energie_n_x_facteur_jones_avec_fibres_kj_100gDesignation = "ORIGGPFR";
    private final static String energie_n_x_facteur_jones_avec_fibres_kcal_100gDesignation = "ORIGGPFR";
    private final static String polyols_totaux_g_100gDesignation = "ORIGGPFR";
    private final static String fibres_g_100gDesignation = "ORIGGPFR";
    private final static String eau_g_100gDesignation = "ORIGGPFR";
    private final static String lipides_g_100gDesignation = "ORIGGPFR";
    private final static String ag_satures_g_100gDesignation = "ORIGGPFR";
    private final static String ag_monoinsatures_g_100gDesignation = "ORIGGPFR";
    private final static String ag_polyinsatures_g_100gDesignation = "ORIGGPFR";
    private final static String ag_4_0_butyrique_g_100gDesignation = "ORIGGPFR";
    private final static String ag_6_0_caproique_g_100gDesignation = "ORIGGPFR";
    private final static String ag_8_0_caprylique_g_100gDesignation = "ORIGGPFR";
    private final static String ag_10_0_caprique_g_100gDesignation = "ORIGGPFR";
    private final static String ag_12_0_laurique_g_100gDesignation = "ORIGGPFR";
    private final static String ag_14_0_myristique_g_100gDesignation = "ORIGGPFR";
    private final static String ag_16_0_palmitique_g_100gDesignation = "ORIGGPFR";
    private final static String ag_18_0_stearique_g_100gDesignation = "ORIGGPFR";
    private final static String ag_18_1_9c_n_9_oleique_g_100gDesignation = "ORIGGPFR";
    private final static String ag_18_2_9c_12c_n_6_linoleique_g_100gDesignation = "ORIGGPFR";
    private final static String ag_18_3_c9_c12_c15_n_3_alpha_linolenique_g_100gDesignation = "ORIGGPFR";
    private final static String ag_20_4_5c_8c_11c_14c_n_6_arachidonique_g_100gDesignation = "ORIGGPFR";
    private final static String ag_20_5_5c_8c_11c_14c_17c_n_3_epa_g_100gDesignation = "ORIGGPFR";
    private final static String ag_22_6_4c_7c_10c_13c_16c_19c_n_3_dha_g_100gDesignation = "ORIGGPFR";
    private final static String retinol_ug_100gDesignation = "ORIGGPFR";
    private final static String beta_carotene_ug_100gDesignation = "ORIGGPFR";
    private final static String vitamine_d_ug_100gDesignation = "ORIGGPFR";
    private final static String vitamine_e_mg_100gDesignation = "ORIGGPFR";
    private final static String vitamine_k_ug_100gDesignation = "ORIGGPFR";
    private final static String vitamine_c_mg_100gDesignation = "ORIGGPFR";
    private final static String vitamine_b1_ou_thiamine_mg_100gDesignation = "ORIGGPFR";
    private final static String vitamine_b2_ou_riboflavine_mg_100gDesignation = "ORIGGPFR";
    private final static String vitamine_b3_ou_pp_ou_niacine_mg_100gDesignation = "ORIGGPFR";
    private final static String vitamine_b5_ou_acide_pantothenique_mg_100gDesignation = "ORIGGPFR";
    private final static String vitamine_b6_mg_100gDesignation = "ORIGGPFR";
    private final static String vitamine_b12_ug_100gDesignation = "ORIGGPFR";
    private final static String vitamine_b9_ou_folates_totaux_ug_100gDesignation = "ORIGGPFR";
    private final static String alcool_g_100gDesignation = "ORIGGPFR";
    private final static String acides_organiques_g_100gDesignation = "ORIGGPFR";
    private final static String cholesterol_mg_100gDesignation = "ORIGGPFR";

    @Id
    private String id;
    private double origgpcd;
    private String origgpfr;
    private int origfdcd;
    private String origfdnm;
    private double sodium_mg_100g;
    private double magnesium_mg_100g;
    private double phosphore_mg_100g;
    private double potassium_mg_100g;
    private double calcium_mg_100g;
    private double manganese_mg_100g;
    private double fer_mg_100g;
    private double cuivre_mg_100g;
    private double zinc_mg_100g;
    private double selenium_ug_100g;
    private double iode_ug_100g;
    private double proteines_g_100g;
    private double proteines_brutes_n_x_6_25_g_100g;
    private double glucides_g_100g;
    private double sucres_g_100g;
    private double energie_reglement_ue_1169_2011_kj_100g;
    private double energie_reglement_ue_1169_2011_kcal_100g;
    private double amidon_g_100g;
    private double energie_n_x_facteur_jones_avec_fibres_kj_100g;
    private double energie_n_x_facteur_jones_avec_fibres_kcal_100g;
    private double polyols_totaux_g_100g;
    private double fibres_g_100g;
    private double eau_g_100g;
    private double lipides_g_100g;
    private double ag_satures_g_100g;
    private double ag_monoinsatures_g_100g;
    private double ag_polyinsatures_g_100g;
    private double ag_4_0_butyrique_g_100g;
    private double ag_6_0_caproique_g_100g;
    private double ag_8_0_caprylique_g_100g;
    private double ag_10_0_caprique_g_100g;
    private double ag_12_0_laurique_g_100g;
    private double ag_14_0_myristique_g_100g;
    private double ag_16_0_palmitique_g_100g;
    private double ag_18_0_stearique_g_100g;
    private double ag_18_1_9c_n_9_oleique_g_100g;
    private double ag_18_2_9c_12c_n_6_linoleique_g_100g;
    private double ag_18_3_c9_c12_c15_n_3_alpha_linolenique_g_100g;
    private double ag_20_4_5c_8c_11c_14c_n_6_arachidonique_g_100g;
    private double ag_20_5_5c_8c_11c_14c_17c_n_3_epa_g_100g;
    private double ag_22_6_4c_7c_10c_13c_16c_19c_n_3_dha_g_100g;
    private double retinol_ug_100g;
    private double beta_carotene_ug_100g;
    private double vitamine_d_ug_100g;
    private double vitamine_e_mg_100g;
    private double vitamine_k_ug_100g;
    private double vitamine_c_mg_100g;
    private double vitamine_b1_ou_thiamine_mg_100g;
    private double vitamine_b2_ou_riboflavine_mg_100g;
    private double vitamine_b3_ou_pp_ou_niacine_mg_100g;
    private double vitamine_b5_ou_acide_pantothenique_mg_100g;
    private double vitamine_b6_mg_100g;
    private double vitamine_b12_ug_100g;
    private double vitamine_b9_ou_folates_totaux_ug_100g;
    private double alcool_g_100g;
    private double acides_organiques_g_100g;
    private double cholesterol_mg_100g;

    public ProductCiqual(){

    }

    /**
     * Create a Product from a list of parameters
     * @param listFields
     * @return
     */
    public static ProductCiqual createProduct(List<String> listFields){

        int i=0;
        ProductCiqual p = new ProductCiqual();

        p.setOriggpcd(ProductOperations.parseDouble(listFields.get(i++)));
        p.setOriggpfr(listFields.get(i++));
        p.setOrigfdcd(ProductOperations.parseInt(listFields.get(i++)));
        p.setOrigfdnm(listFields.get(i++));
        
        p.setSodium_mg_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setMagnesium_mg_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setPhosphore_mg_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setPotassium_mg_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setCalcium_mg_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setManganese_mg_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setFer_mg_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setCuivre_mg_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setZinc_mg_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setSelenium_ug_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setIode_ug_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setProteines_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setProteines_brutes_n_x_6_25_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setGlucides_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setSucres_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setEnergie_reglement_ue_1169_2011_kj_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setEnergie_reglement_ue_1169_2011_kcal_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setAmidon_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setEnergie_n_x_facteur_jones_avec_fibres_kj_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setEnergie_n_x_facteur_jones_avec_fibres_kcal_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setPolyols_totaux_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setFibres_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setEau_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setLipides_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setAg_satures_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setAg_monoinsatures_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setAg_polyinsatures_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setAg_4_0_butyrique_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setAg_6_0_caproique_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setAg_8_0_caprylique_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setAg_10_0_caprique_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setAg_12_0_laurique_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setAg_14_0_myristique_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setAg_16_0_palmitique_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setAg_18_0_stearique_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setAg_18_1_9c_n_9_oleique_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setAg_18_2_9c_12c_n_6_linoleique_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setAg_18_3_c9_c12_c15_n_3_alpha_linolenique_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setAg_20_4_5c_8c_11c_14c_n_6_arachidonique_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setAg_20_5_5c_8c_11c_14c_17c_n_3_epa_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setAg_22_6_4c_7c_10c_13c_16c_19c_n_3_dha_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setRetinol_ug_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setBeta_carotene_ug_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setVitamine_d_ug_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setVitamine_e_mg_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setVitamine_k_ug_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setVitamine_c_mg_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setVitamine_b1_ou_thiamine_mg_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setVitamine_b2_ou_riboflavine_mg_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setVitamine_b3_ou_pp_ou_niacine_mg_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setVitamine_b5_ou_acide_pantothenique_mg_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setVitamine_b6_mg_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setVitamine_b12_ug_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setVitamine_b9_ou_folates_totaux_ug_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setAlcool_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setAcides_organiques_g_100g(ProductOperations.parseDouble(listFields.get(i++)));
        p.setCholesterol_mg_100g(ProductOperations.parseDouble(listFields.get(i++)));

        return p;
    }

    public Collection<ProductField> getProductCiqualWithDesignation(){

        Collection<ProductField> productCiqualFields = new ArrayList<>();

        productCiqualFields.add(new ProductField(idDesignation, this.getId()));
        productCiqualFields.add(new ProductField(origgpcdDesignation, this.getOriggpcd()));
        productCiqualFields.add(new ProductField(origgpfrDesignation, this.getOriggpfr()));

        return productCiqualFields;
    }

}
