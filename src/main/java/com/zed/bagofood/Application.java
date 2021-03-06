package com.zed.bagofood;

import com.zed.bagofood.data.ImportCsvDataFromCiqual2012;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.zed.bagofood.data.ImportCsvData;
import com.zed.bagofood.data.ImportCsvDataFromOpenFoodFacts;
import com.zed.bagofood.model.User;

@SpringBootApplication
public class Application implements CommandLineRunner {

    /**
     * Class Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Application.class);
//
//    @Value("${test}")
//    private String test;

    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

    	ImportCsvData importCsvData = new ImportCsvDataFromCiqual2012(mongoTemplate);
    	importCsvData.insertDataIntoDBFromCsvFile();
    }

}
