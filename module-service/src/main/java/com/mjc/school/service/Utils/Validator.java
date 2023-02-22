package com.mjc.school.service.Utils;

import com.mjc.school.controller.entity.NewsDto;
import com.mjc.school.service.exceptions.NewsValidationException;

public class Validator {

    private static Validator validatorInstance;

    public Validator() {
    }

    public static Validator getValidatorInstance() {
        if(validatorInstance==null){
            validatorInstance = new Validator();
        }
        return validatorInstance;
    }

    public void validate(NewsDto newsDTO) throws NewsValidationException {
        if (!(newsDTO.getTitle().length() >= 5 && newsDTO.getTitle().length() <= 30)) {
            throw new NewsValidationException("News was not updated, as length of the title is less of 5 or more than 30." + newsDTO.getTitle() + ": " + newsDTO.getTitle().length());
        }
        if (!(newsDTO.getContent().length() >= 5 && newsDTO.getContent().length() <= 255)) {
            throw new NewsValidationException("News was not updated, as length of the content is less of 5 or more than 255 " + newsDTO.getContent() + ": " + newsDTO.getContent().length());
        }
    }
}
