package com.mjc.school.service.interfaces;

import com.mjc.school.controller.entity.NewsDTO;
import com.mjc.school.service.exceptions.NewsValidationException;

public interface Validating {
    void validate(NewsDTO newsDTO) throws NewsValidationException;
}
