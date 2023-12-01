package com.example.reactive.service.impl;


import com.example.reactive.dto.GetMdResponseDto;
import com.example.reactive.mapper.GetMdMapper;
import com.example.reactive.mapper.MdMapper;
import com.example.reactive.repository.MdRepo;
import com.example.reactive.service.MdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class MdServiceImpl implements MdService {

    @Autowired
    private MdRepo mdRepo;

    @Override
    public Mono<GetMdResponseDto> findByMdNumber(String mdNumber) {
        try {
            Mono<GetMdResponseDto> resutl =  this.mdRepo.findByMdDealNo(mdNumber)
                    .map(MdMapper.INSTANCE::mdResponseDto);
            return resutl;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return  null;

    }
}
