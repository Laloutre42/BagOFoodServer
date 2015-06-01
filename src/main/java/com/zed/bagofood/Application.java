package com.zed.bagofood;

/**
 * Created by Arnaud on 30/04/2015.
 */

import com.zed.bagofood.model.Product;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

    /**
     * Class Logger
     */
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        //insertDataFromCiqualCsv();
    }

    /**
     * Import data from a CSV file Ciqual_2012
     */
    private void insertDataFromCiqualCsv() {

        // Delete old values
        mongoTemplate.dropCollection(Product.class);

        Path path = Paths.get("F:/DEV/ProjectJs/BagOFoodGulp/data/Ciqual_2012/input.csv");
        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String line = null;
            while ((line = reader.readLine()) != null) {
                Product product = Product.createProduct(Arrays.asList(line.split(",")));
                mongoTemplate.insert(product);
                logger.info("Insert: " + product);
            }

        } catch (IOException e) {
            logger.error("IOException", e);
        }
    }

}
