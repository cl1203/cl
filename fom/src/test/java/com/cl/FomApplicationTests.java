package com.cl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cl.config.CommonConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FomApplicationTests {

	@Autowired
	private CommonConfig config;
	
	@Test
	public void testConfig() {
		System.out.println(config.getAppId());
	}
	
	@Test
	public void testConfig1() {
		System.out.println(config.getAppId());
	}

}
