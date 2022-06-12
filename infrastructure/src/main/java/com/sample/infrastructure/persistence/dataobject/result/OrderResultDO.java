package com.sample.infrastructure.persistence.dataobject.result;

import com.sample.api.dto.OrderDTO;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Getter
@Setter
public class OrderResultDO {
    public static Converter MAPPER = Mappers.getMapper(Converter.class);


    private String username;

    @Mapper
    public interface Converter {
        List<OrderDTO> toDTO(List<OrderResultDO> orderResultDOList);
    }
}
