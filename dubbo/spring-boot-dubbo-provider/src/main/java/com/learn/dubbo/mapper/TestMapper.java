package com.learn.dubbo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.learn.dubbo.bean.Test;

@Repository
public interface TestMapper {

	@Select("select * from t_test")
	List<Test> selectTest();

}
