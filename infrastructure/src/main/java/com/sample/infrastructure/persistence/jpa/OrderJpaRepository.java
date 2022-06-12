package com.sample.infrastructure.persistence.jpa;

import com.sample.infrastructure.persistence.dataobject.persist.OrderPO;
import org.springframework.data.repository.CrudRepository;


public interface OrderJpaRepository extends CrudRepository<OrderPO, Long> {

}
