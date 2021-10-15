package com.amitu.unit.testing.data;

import org.springframework.stereotype.Service;

@Service
public class SomeDataServiceImpl implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {5,6,7};
	}

}
