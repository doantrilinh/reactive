package com.example.reactive.handler;

import com.example.reactive.dto.GetMdRequestDto;
import com.example.reactive.dto.GetMdResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Slf4j
public abstract class AbstractValidationHandler<T, U extends SpringValidatorAdapter> {
    private final Class<T> validationDataClass;
    private final U validator;
    protected String function;


    protected AbstractValidationHandler(Class<T> data, U validator, String function) {
        this.validator = validator;
        this.validationDataClass = data;
        this.function = function;
    }

    public final Mono<GetMdResponseDto> handleRequest(Mono<T> request) {
        return request.flatMap(
                body -> {
                    Errors abstractClassErrors = new BeanPropertyBindingResult(body, validationDataClass.getClass().getName());
                    this.validator.validate(body, abstractClassErrors);
                    if (abstractClassErrors.hasErrors() || body == null) {
                        System.err.println("loi me roi ");
                        return Mono.error(new RuntimeException("Error occurred"));
                    } else {
                        System.err.println("Khong loi ");
                        GetMdResponseDto response = new GetMdResponseDto();
                        response.setMdNumber("adasdsds");
                        return Mono.just(response);
                    }
                }
        );
    }
    protected Mono<ServerResponse> onValidateErrors(RequestDto<Object> req, Errors errors) {
        var errorMessage = errors.getAllErrors()
                .stream()
                .map(err -> err.getDefaultMessage())
                .collect(Collectors.joining("; "));
        return ServerResponse
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(ResponseDto.buildResponse(req, null, ResponseCode.INVALID_REQUEST.getCode(), errorMessage)), ResponseDto.class)
                .onErrorResume(err -> ServerResponse
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(err.getMessage()));
    }


}
