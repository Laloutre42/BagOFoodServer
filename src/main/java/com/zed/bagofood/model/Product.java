package com.zed.bagofood.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Arnaud on 18/05/2015.
 */
@Data
@Document
public class Product {

    @Id
    private String id;
    private int origgpcd;
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
    private double selenium_µg_100g;
    private double iode_µg_100g;
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
    private double ag_6_0_caproïque_g_100g;
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
    private double retinol_µg_100g;
    private double beta_carotene_µg_100g;
    private double vitamine_d_µg_100g;
    private double vitamine_e_mg_100g;
    private double vitamine_k_µg_100g;
    private double vitamine_c_mg_100g;
    private double vitamine_b1_ou_thiamine_mg_100g;
    private double vitamine_b2_ou_riboflavine_mg_100g;
    private double vitamine_b3_ou_pp_ou_niacine_mg_100g;
    private double vitamine_b5_ou_acide_pantothenique_mg_100g;
    private double vitamine_b6_mg_100g;
    private double vitamine_b12_µg_100g;
    private double vitamine_b9_ou_folates_totaux_µg_100g;
    private double alcool_g_100g;
    private double acides_organiques_g_100g;
    private double cholesterol_mg_100g;

    public Product(){

    }



}
