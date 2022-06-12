package com.sample.domain.aggregate.order;

public interface OrderIdGenerator {
    /**
     * 生成全局唯一的用户ID
     */
    Long generate();
}
