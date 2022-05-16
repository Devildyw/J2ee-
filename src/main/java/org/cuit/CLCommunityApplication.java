package org.cuit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.cuit.mapper")
public class CLCommunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CLCommunityApplication.class, args);
	}

}