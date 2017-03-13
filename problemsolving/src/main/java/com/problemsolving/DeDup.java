package com.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeDup 
{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DeDup.class);
	
	protected static int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   

	
	
    public static void main( String[] args )
    {
       
    	LOGGER.info("Inside main Method");
    	
    	removeDupUsingArrayList(randomIntegers);
    	
        removeDupRetainOriginalOrder(randomIntegers);
        removeDuplicatesWithSet(randomIntegers);
        removeDuplicatesInStream(randomIntegers);
        
    }
    
    
    //ArrayList is used.
    
    public static int[] removeDupUsingArrayList(int[] intArr){
    	
    	LOGGER.info("Inside removeDupUsingArrayList Method");
    	
    	int[] deDupArr = null;
    	
    	if (ArrayUtils.isNotEmpty(intArr)) {

    		List<Integer> deduplist = new ArrayList<>();

    		for(int i=0; i<intArr.length; i++)
    		{
    			boolean match = false;
    			for(int j=0; j<deduplist.size(); j++)
    			{
    				//if the list contains any input element make match true
    				if(deduplist.get(j) == intArr[i])
    					match = true;
    			}
    			//if there is no matching we can add the element to the result list
    			if(!match)
    				deduplist.add(intArr[i]);
    		}

    		deDupArr = deduplist.stream().mapToInt(i->i).toArray();
    	}
        return deDupArr;
    }    
    
    
    //LinkedHashset is used to retain the order
    
    public static int[] removeDupRetainOriginalOrder(int[] intArr){
    	
		LOGGER.info("Inside removeDup Method - Using LinkedHashSet to retain the original order");
		int[] deDupArr = null;

    	Set<Integer> setString = new LinkedHashSet<>();

    	if (ArrayUtils.isNotEmpty(intArr)) {

    		for(int i=0;i<intArr.length;i++){
    			setString.add(intArr[i]);
    		}
        
    	deDupArr = setString.stream().mapToInt(Number::intValue).toArray();
    	}
    	return deDupArr;
    }    

    public static int[] removeDuplicatesWithSet(int[] intArr) {
    	
    	LOGGER.info("Inside removeDuplicatesWithSet Method");
    	
    	if (ArrayUtils.isEmpty(intArr)) {
    		return null;
    	}
    		
        Set<Integer> alreadyPresent = new HashSet<>();
        int[] whitelist = new int[intArr.length];
        int i = 0;

        for (int element : intArr) {
            if (alreadyPresent.add(element)) {
                whitelist[i++] = element;
            }
        }
        return Arrays.copyOf(whitelist, i);
    }
 
    
    //Using Java8 IntStream
    public static int[] removeDuplicatesInStream(int[] intArr) {
    	
    	LOGGER.info("Inside removeDuplicatesInStream Method");

    	int[] result = null;
    	if (ArrayUtils.isNotEmpty(intArr)) {
    		result = IntStream.of(intArr).distinct().toArray();
    	}
    	return result;
  	  
   	}  
       
}
