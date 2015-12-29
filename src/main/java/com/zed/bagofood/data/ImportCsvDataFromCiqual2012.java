package com.zed.bagofood.data;

import java.util.List;

import com.zed.bagofood.model.product.ProductCiqual;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

public class ImportCsvDataFromCiqual2012 extends ImportCsvData{
	
	private final static String FILE_PATH = "C:/DEV/repo/BagOFoodGulp/data/Ciqual_2012/input.csv";
	private final static String SEPARATOR = ",";
	private final static String COLLECTION_NAME = "ProductCiqual";
	
    /**
     * Class Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ImportCsvDataFromCiqual2012.class);	
    
    public ImportCsvDataFromCiqual2012(MongoTemplate mongoTemplate) {
    	super(mongoTemplate);
	}
    
	@Override
	protected void createAndInsertProductModel(List<String> lineSplitted) {
        ProductCiqual product = ProductCiqual.createProduct(lineSplitted);
        mongoTemplate.insert(product);
        logger.info("Insert: " + product);
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
