package com.amitu.unit.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.amitu.unit.testing.business.SomeBusinessImpl;
import com.amitu.unit.testing.data.SomeDataService;
import com.amitu.unit.testing.data.SomeDataServiceImpl;

class SomeDataServiceStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {1,2,3};
	}
	
}

class SomeDataServiceEmptyStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
	
}


class SomeDataServiceOneElementStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		return new int[] {5};
	}
	
}


public class SomeBusinessStubTest {

	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		
		//business.setSomeDataService(new SomeDataServiceImpl());
		
		business.setSomeDataService(new SomeDataServiceStub());
		
		int actualResult = business.calculateSumUsingDataService();
		
		//int expectedResult = 18;
		
	    int expectedResult = 6;
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSumUsingDataService_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceEmptyStub());
		
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void calculateSumUsingDataService_oneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		
		business.setSomeDataService(new SomeDataServiceOneElementStub());
		int actualResult = business.calculateSumUsingDataService();
		int expectedResult = 5;
		assertEquals(expectedResult, actualResult);
	}
	
	

}
