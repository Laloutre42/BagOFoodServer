package com.zed.bagofood;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zed.bagofood.data.ImportCsvData;
import com.zed.bagofood.data.ImportCsvDataFromCiqual2012;
import com.zed.bagofood.repository.ProductCiqualRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

    /**
     * Class Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Application.class);
//
//    @Value("${test}")
//    private String test;
    
    @Inject
    private ProductCiqualRepository productCiqualRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

    	if ((strings.length > 0) && (strings[0].equals("import-ciqual-2012"))){

    		logger.debug("Import Ciqual 2012 ...");
    		
    		ImportCsvData importCsvData = new ImportCsvDataFromCiqual2012(productCiqualRepository);
    		importCsvData.insertDataIntoDBFromCsvFile();

    		logger.debug("Import Ciqual 2012 - done");
    	}

    }

}
