package com.HeartMediaAssignment;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.HeartMediaAssignment.Entity.Advertiser;

@MappedTypes(Advertiser.class)
@MapperScan("com.HeartMediaAssignment.Mapper")
@SpringBootApplication
public class IHeartMediaAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(IHeartMediaAssignmentApplication.class, args);
	}
}
