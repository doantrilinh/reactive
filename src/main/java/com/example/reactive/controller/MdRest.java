package com.example.reactive.controller;


import com.example.reactive.dto.GetMdRequestDto;
import com.example.reactive.dto.GetMdResponseDto;
import com.example.reactive.handler.MdHandler;
import com.example.reactive.service.MdService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1")
@Configuration
@RequiredArgsConstructor
public class MdRest {

    @Autowired
    private MdService mdService;


    @Autowired
    private MdHandler handler;

    @PostMapping(value ="/getMd")
    Mono<GetMdResponseDto> getMd( @RequestBody Mono<GetMdRequestDto> requestDto){
        try {
            GetMdRequestDto getMdRequestDto = new GetMdRequestDto();
            getMdRequestDto.setMdNumber("adasdsds");
            Mono<GetMdRequestDto> input = Mono.just(getMdRequestDto);
            Mono<GetMdResponseDto> mono= input.flatMap(
                    body -> {
                            GetMdResponseDto response = new GetMdResponseDto();
                            response.setMdNumber("adasdsds");
                            return Mono.just(response);
                    }
            );
            mono.subscribe( t -> System.err.println(t.getMdNumber()));
//            Mono<ServerResponse> res = handler.handleRequest2(getMdRequestDto);
            return  handler.handleRequest(requestDto);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }
}
