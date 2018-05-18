package com.HeartMediaAssignment.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.HeartMediaAssignment.Entity.Advertiser;

@Mapper
public interface AdvertiserMapper {
	
	
	@Insert("INSERT into advertiser(name,company_name,credit_score) VALUES(#{name}, #{companyName}, #{creditScore})")
	void insertAdvertiser(Advertiser advertiser);
	
	@Select("select * from advertiser where name = #{name}")
	@Results({
		 @Result(property = "companyName", column = "company_name"),
		 @Result(property = "creditScore", column = "credit_score"),
})
	Advertiser getAdvertiser(String name);
	
	@Select("select * from advertiser")
	@Results({
		 @Result(property = "companyName", column = "company_name"),
		 @Result(property = "creditScore", column = "credit_score"),
})
	List<Advertiser> getAllAdvertiser();
	
	@Update("UPDATE advertiser SET credit_score=#{creditScore}, company_name =#{companyName} WHERE name =#{name}")
	void updateAdvertiser(Advertiser advertiser);
	
	@Delete("DELETE FROM advertiser WHERE name =#{name}")
	void deleteAdvertiser(String name);

	

}
