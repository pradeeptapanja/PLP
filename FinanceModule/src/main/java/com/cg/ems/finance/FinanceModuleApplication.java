package com.cg.ems.finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@EnableDiscoveryClient
//@ComponentScan("com.cg.ems.finance")
public class FinanceModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceModuleApplication.class, args);
	}

}
