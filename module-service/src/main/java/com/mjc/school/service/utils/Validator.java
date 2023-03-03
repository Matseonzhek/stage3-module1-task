package com.mjc.school.service.utils;

import com.mjc.school.service.dto.AuthorDto;
import com.mjc.school.service.dto.NewsDto;
import com.mjc.school.service.exceptions.ValidationException;

public class Validator {
    private static final String NEWS_ID = "News id";
    private static final String AUTHOR_ID = "Author id";
    private static final Integer NEWS_TITLE_MIN = 5;
    private static final Integer NEWS_TITLE_MAX = 30;
    private static final Integer NEWS_CONTENT_MIN = 5;
    private static final Integer NEWS_CONTENT_MAX = 255;
    private static final Integer AUTHOR_NAME_MIN = 3;
    private static final Integer AUTHOR_NAME_MAX = 15;
    private static final Integer MAX_AUTHOR_ID = 5;

    private static final String ERROR_VALUE_STRING = "Text length does not meet requirements: negative, null, less or more than necessary.";
    private static final String ERROR_VALUE_NUMBER = "Id does not meet requirements: negative, null, less or more than necessary.";

    private static Validator validatorInstance;

    private Validator() {
    }

    public static Validator getValidatorInstance() {
        if (validatorInstance == null) {
            validatorInstance = new Validator();
        }
        return validatorInstance;
    }

    public void validateNewsId(Long id) {
        validateNumber(id, NEWS_ID);
    }

    public void validateAuthorId(Long id) {
        validateNumber(id, AUTHOR_ID);
        if (id > MAX_AUTHOR_ID) {
            throw new ValidationException(ERROR_VALUE_NUMBER + " " + id);
        }
    }

    public void validateNewsDto(NewsDto newsDTO) {
        validateString(newsDTO.getTitle(), NEWS_ID, NEWS_TITLE_MIN, NEWS_TITLE_MAX);
        validateString(newsDTO.getContent(), NEWS_ID, NEWS_CONTENT_MIN, NEWS_CONTENT_MAX);
        validateAuthorId(newsDTO.getAuthorId());
    }

    public void validateAuthorDto(AuthorDto authorDto) {
        validateString(authorDto.getName(), AUTHOR_ID, AUTHOR_NAME_MIN, AUTHOR_NAME_MAX);
    }

    private void validateString(String value, String parameter, int minNumber, int maxNumber) {
        if (value == null) {
            throw new ValidationException(ERROR_VALUE_STRING + "(" + parameter + ")");
        }
        if (value.trim().length() < minNumber || value.trim().length() > maxNumber) {
            throw new ValidationException(ERROR_VALUE_STRING + "(" + parameter + ")");
        }
    }

    private void validateNumber(Long id, String parameter) {
        if (id == null || id < 1) {
            throw new ValidationException(ERROR_VALUE_NUMBER + "(" + parameter + ")");
        }
    }
}
