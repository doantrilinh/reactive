package com.example.reactive.service.impl;


import com.example.reactive.dto.GetMdResponseDto;
import com.example.reactive.mapper.GetMdMapper;
import com.example.reactive.repository.MdRepo;
import com.example.reactive.service.MdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MdServiceImpl implements MdService {

    @Autowired
    private MdRepo mdRepo;


    @Autowired
    private GetMdMapper getMdMapper;

    @Override
    public Mono<GetMdResponseDto> findByMdNumber(String mdNumber) {
        try {
            Mono<GetMdResponseDto> resutl =  this.mdRepo.findByMdDealNo(mdNumber)
                    .map(e -> getMdMapper.mapper(e));
            return resutl;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return  null;

    }
}
