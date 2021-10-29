package com.stkmrkt.stockdetails.constants;

public class Constants {

	public static final String API_CONTEXT_ROOT = "stockdetails/v1.0/market";
	public static final String SAVE_COMPANY_STOCK_URI = "/save/stock";
	public static final String DELETE_STOCK_BY_ID_URI = "/delete/stock/{stockId}";
	public static final String DELETE_STOCK_BY_CPMYCDE_URI = "/delete/stock/companyCode/{companyCode}";
	public static final String FETCH_ALL_STOCK_URI = "/getAll/stock";
	public static final String FETCH_ALL_LATEST_STOCK_URI = "/getAll/latest/stock";
	public static final String FETCH_STOCK_BY_ID_URI = "/get/stock/{stockId}";
	public static final String FETCH_STOCK_BY_RANGE_URI = "/get/stock/{companyCode}/{startDate}/{endDate}";
	public static final String FETCH_STOCK_BY_CPMYCDE_URI = "/get/stock/companyCode/{companyCode}";
	public static final String FETCH_LATEST_STOCK_BY_CPMYCDE_URI = "/get/latest/stock/companyCode/{companyCode}";
	public static final String STOCK_DETAILS_CONTROLLER = "STOCK DETAILS CONTROLLER";

}
