package com.zed.bagofood.model.product;

public class ProductOperations {
	
	

	public static double parseDouble(String s){
        return s.isEmpty() ? 0.0 : Double.parseDouble(s);
    }
	public static int parseInt(String s){
        return s.isEmpty() ? 0 : Integer.parseInt(s);
    }
		
}
