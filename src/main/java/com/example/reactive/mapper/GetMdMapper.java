package com.example.reactive.mapper;

import com.example.reactive.dto.GetMdResponseDto;
import com.example.reactive.entity.Md;
import org.springframework.stereotype.Service;

@Service
public class GetMdMapper {

    public GetMdResponseDto mapper(Md entity) {

        GetMdResponseDto getMdResponseDto = new GetMdResponseDto();
        getMdResponseDto.setMdCurrency(entity.getMdCurrency());
        getMdResponseDto.setMdNumber(entity.getMdDealNo());
        return getMdResponseDto;
    }
}
