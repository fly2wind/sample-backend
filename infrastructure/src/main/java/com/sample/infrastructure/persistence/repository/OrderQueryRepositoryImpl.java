package com.sample.infrastructure.persistence.repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sample.api.dto.OrderDTO;
import com.sample.api.dto.query.OrderQueryDTO;
import com.sample.api.support.Page;
import com.sample.application.repository.OrderQueryRepository;
import com.sample.infrastructure.persistence.dataobject.result.OrderResultDO;
import com.sample.infrastructure.persistence.mybatis.OrderMybatisMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderQueryRepositoryImpl implements OrderQueryRepository {
    private final OrderMybatisMapper orderMybatisMapper;

    @Override
    public Page<OrderDTO> findAll(OrderQueryDTO orderQueryDTO) {
        PageHelper.startPage(orderQueryDTO.getPageNumber(), orderQueryDTO.getPageSize());
        List<OrderResultDO> users = orderMybatisMapper.findBy(orderQueryDTO.getUsername());
        PageInfo<OrderResultDO> pageInfo = PageInfo.of(users);

        return new Page<>(OrderResultDO.MAPPER.toDTO(users), pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal());
    }
}
