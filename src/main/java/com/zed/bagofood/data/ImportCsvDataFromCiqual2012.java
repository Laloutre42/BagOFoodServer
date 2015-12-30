package com.zed.bagofood.data;

import java.util.List;

import com.zed.bagofood.model.product.ProductCiqual;
import com.zed.bagofood.repository.ProductCiqualRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImportCsvDataFromCiqual2012 extends ImportCsvData {

	private final static String FILE_PATH = "data/Ciqual_2012/input.csv";
	private final static String SEPARATOR = ",";
	
	private ProductCiqualRepository productCiqualRepository;

	/**
	 * Class Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ImportCsvDataFromCiqual2012.class);

	public ImportCsvDataFromCiqual2012(ProductCiqualRepository productCiqualRepository) {
		this.productCiqualRepository = productCiqualRepository;
	}

	@Override
	protected void createAndInsertProductModel(List<String> lineSplitted) {
        ProductCiqual product = ProductCiqual.createProduct(lineSplitted);
        productCiqualRepository.save(product);
        logger.info("Insert: " + product);
	}
	
	@Override
	protected void deleteAll() {
		productCiqualRepository.deleteAll();
	}

	@Override
	protected String getFilePath() {
		return FILE_PATH;
	}

	@Override
	protected String getSeparator() {
		return SEPARATOR;
	}

}
