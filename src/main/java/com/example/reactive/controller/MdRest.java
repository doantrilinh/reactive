package com.example.reactive.controller;


import com.example.reactive.dto.GetMdRequestDto;
import com.example.reactive.dto.GetMdResponseDto;
import com.example.reactive.service.MdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1")
public class MdRest {

    @Autowired
    private MdService mdService;

    @PostMapping(value ="/getMd")
    Mono<GetMdResponseDto> getMd( @RequestBody GetMdRequestDto requestDto){
        try {
            String mdNumber = requestDto.getMdNumber();
            Mono<GetMdResponseDto> result = this.mdService.findByMdNumber(mdNumber);
            return  result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }
}
