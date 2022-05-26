package org.cuit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Devil
 * @since 2022-05-20
 */
@SpringBootApplication
@MapperScan("org.cuit.mapper")
//@ComponentScan("org.*")
public class CLCommunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CLCommunityApplication.class, args);
	}

}