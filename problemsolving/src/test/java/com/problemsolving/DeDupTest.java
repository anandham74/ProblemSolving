package com.problemsolving;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;



public class DeDupTest {
	
	private static final int[] inputRandomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
	        20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
	        13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11}; 

	private static final int[] resultRandomIntegers = {1, 2, 34, 25, 45, 3, 26, 85, 4, 86, 43,
		                10000, 11, 16, 19, 18, 9, 20, 17, 8, 15, 6, 5, 10, 14, 12, 13, 7};	
	
	private static final int[] nullArray= null;
	
	private static final int[] emptyArray= new int[]{};
	
	@Test
	public void testRemoveDupUsingArrayList() {
		Assert.assertArrayEquals(resultRandomIntegers, DeDup.removeDupUsingArrayList(inputRandomIntegers));
		
	}
	
	@Test
	public void testRemoveDupUsingArrayListNullOrEmptyInput() {
		Assert.assertNull(DeDup.removeDupUsingArrayList(nullArray));
		Assert.assertNull(DeDup.removeDupUsingArrayList(emptyArray));
	}
	
	
	@Test
	public void testRemoveDuplicatesWithSet() {
		Assert.assertArrayEquals(resultRandomIntegers, DeDup.removeDuplicatesWithSet(inputRandomIntegers));
		
	}	
	
	@Test
	public void testRemoveDuplicatesWithSetNullOrEmptyInput() {
		Assert.assertNull(DeDup.removeDuplicatesWithSet(nullArray));
		Assert.assertNull(DeDup.removeDuplicatesWithSet(emptyArray));
	}	

	@Test
	public void testRemoveDuplicatesInStream() {
		Assert.assertArrayEquals(resultRandomIntegers, DeDup.removeDuplicatesInStream(inputRandomIntegers));
		
	}
	
	@Test
	public void testRemoveDupUsingInStreamNullOrEmptyInput() {
		Assert.assertNull(DeDup.removeDuplicatesInStream(nullArray));
		Assert.assertNull(DeDup.removeDuplicatesInStream(emptyArray));
	}

	
	@Test
	public void removeDupRetainOriginalOrder() {
		Assert.assertArrayEquals(resultRandomIntegers, DeDup.removeDupRetainOriginalOrder(inputRandomIntegers));
	}
	
	@Test
	public void testRemoveDupRetainOriginalOrderNullOrEmptyInput() {
		Assert.assertNull(DeDup.removeDupRetainOriginalOrder(nullArray));
		Assert.assertNull(DeDup.removeDupRetainOriginalOrder(emptyArray));
	}	
	
}
