package com.example.reactive.mapper;

import com.example.reactive.dto.GetMdResponseDto;
import com.example.reactive.entity.Md;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring"
        , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
        , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
        , collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface MdMapper {
    MdMapper INSTANCE = Mappers.getMapper(MdMapper.class);

    @Mapping(target = "mdCurrency", source = "mdCurrency")
    @Mapping(target = "mdNumber", source = "mdDealNo")
    GetMdResponseDto mdResponseDto (Md md);
}
