package br.com.jsn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"br.com.jsn.entity","br.com.jsn.service","br.com.jsn.repository","br.com.jsn.controller" })
public class JsnProductCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsnProductCatalogApplication.class, args);
	}

}
