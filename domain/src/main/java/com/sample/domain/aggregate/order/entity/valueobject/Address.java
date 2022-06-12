package com.sample.domain.aggregate.order.entity.valueobject;

import com.sample.domain.support.ValueObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address implements ValueObject {
    private String province;
    private String city;
    private String detail;


    public Address(String province, String city, String detail) {
        this.province = province;
        this.city = city;
        this.detail = detail;
    }
}
