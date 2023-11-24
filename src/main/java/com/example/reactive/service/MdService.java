package com.example.reactive.service;


import com.example.reactive.dto.GetMdResponseDto;
import reactor.core.publisher.Mono;

public interface MdService {


    Mono<GetMdResponseDto> findByMdNumber(String mdNumber);
}
