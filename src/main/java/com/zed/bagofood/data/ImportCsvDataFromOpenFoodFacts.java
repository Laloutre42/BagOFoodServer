package com.zed.bagofood.data;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.zed.bagofood.model.product.ProductOf;

public class ImportCsvDataFromOpenFoodFacts extends ImportCsvData {
	
	private final static String FILE_PATH = "C:/_FILER/devProjet/BagOFood/data/OpenFoodFact/fr.openfoodfacts.org.products.99_no_headers.csv";
	private final static String SEPARATOR = "\t";
	private final static String COLLECTION_NAME = "ProductOf";
	
    /**
     * Class Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ImportCsvDataFromOpenFoodFacts.class);		
    
    public ImportCsvDataFromOpenFoodFacts(MongoTemplate mongoTemplate) {
    	super(mongoTemplate);
	}

	@Override
	protected void createAndInsertProductModel(List<String> lineSplitted) {
        ProductOf productOf = ProductOf.createProductOf(lineSplitted);
        mongoTemplate.insert(productOf);
        logger.info("Insert: " + productOf);
	}

	@Override
	protected String getFilePath() {
		return FILE_PATH;
	}

	@Override
	protected String getSeparator() {
		return SEPARATOR;
	}
	
	@Override
	protected String getCollectionName() {
		return COLLECTION_NAME;
	}	

}
