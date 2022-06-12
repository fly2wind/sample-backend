package com.sample.infrastructure.persistence.mybatis;

import com.sample.infrastructure.persistence.dataobject.result.OrderResultDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OrderMybatisMapper {

    @Select("SELECT * FROM users")
    List<OrderResultDO> findAll();

    List<OrderResultDO> findBy(@Param("username") String username);
}
