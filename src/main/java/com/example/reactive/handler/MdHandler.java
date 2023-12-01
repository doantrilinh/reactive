package com.example.reactive.handler;

import com.example.reactive.dto.GetMdRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

@Component
@Slf4j
public class MdHandler extends AbstractValidationHandler<GetMdRequestDto, SpringValidatorAdapter> {

    public MdHandler(SpringValidatorAdapter validator) {
        super(GetMdRequestDto.class, validator, "InquiryBctMdHandler");
    }
}
