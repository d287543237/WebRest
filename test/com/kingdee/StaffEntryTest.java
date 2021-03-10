package com.kingdee;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.Assert;

public class StaffEntryTest {

	private final static Logger logger = LoggerFactory.getLogger(StaffEntryTest.class); 
	@Test
	public void testPostRequest() {
		
		System.out.println("test start...");
		
		StaffEntry staffentry=new StaffEntry();
		String result =staffentry.postResult("haha");
		
		System.out.println(result);
		for(int i=0;i<1000;i++) {
			logger.info(result);
		}
		
		Assert.assertEquals("haha中文33", result);
	}

}
