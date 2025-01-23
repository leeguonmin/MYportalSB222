package himedia.myportal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "himedia.myportal.mappers")
public class MyportalSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyportalSbApplication.class, args);
	}

}
