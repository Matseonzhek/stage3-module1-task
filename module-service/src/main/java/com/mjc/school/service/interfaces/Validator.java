package com.mjc.school.service.interfaces;

import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exceptions.NewsValidationException;

public interface Validator {
    void validate(NewsDto newsDTO) throws NewsValidationException;
}

