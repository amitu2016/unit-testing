package com.amitu.unit.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;


public class ListMockTest {

	List<String> mock = mock(List.class);
	
	@Test
	public void size_basic() {
		
		when(mock.size()).thenReturn(5);
		
		assertEquals(5, mock.size());
	}
	
	@Test
	public void size_different() {
			
		when(mock.size()).thenReturn(5).thenReturn(10);
		
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	@Test
	public void withDifferentParameter() {
			
		when(mock.get(0)).thenReturn("Amit Kumar");
		
		assertEquals("Amit Kumar", mock.get(0));
		
	}
	
	@Test
	public void withGenericParameter() {
			
		when(mock.get(anyInt())).thenReturn("Amit Kumar");
		
		assertEquals("Amit Kumar", mock.get(0));
		assertEquals("Amit Kumar", mock.get(1));
	}
	
	@Test
	public void verify() {
		
		String value1 = mock.get(0);
		String value2 = mock.get(1);
		
		//Verify
		Mockito.verify(mock).get(0);
		Mockito.verify(mock, times(2)).get(anyInt());
		Mockito.verify(mock, atLeast(1)).get(anyInt());
		Mockito.verify(mock, atMost(2)).get(anyInt());
		Mockito.verify(mock, atLeastOnce()).get(anyInt());
		Mockito.verify(mock, never()).get(2);
		
	}
	
	@Test
	public void argumentCapturing() {
		
		mock.add("Some Argument Passed");
		
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		Mockito.verify(mock).add(captor.capture());
		
		assertEquals("Some Argument Passed", captor.getValue());
	
	}
	
	@Test
	public void multipleArgumentCapturing() {
		
		mock.add("Some Argument Passed");
		mock.add("Some more Argument Passed");
		
		//Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		Mockito.verify(mock, times(2)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
		
		assertEquals("Some Argument Passed", allValues.get(0));
		assertEquals("Some more Argument Passed", allValues.get(1));
	
	}
	
	@Test
	public void spying() {
		
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0));
		System.out.println(arrayListSpy.size());
		
		arrayListSpy.add("Test");
		
		arrayListSpy.add("Test1");
		System.out.println(arrayListSpy.size());
		
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());
		
		Mockito.verify(arrayListSpy).add("Test");
		
		
	}
	

}
