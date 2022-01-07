package com.xproject.master.app.exception;

import com.xproject.master.app.exception.entity.ErrorData;
import com.xproject.master.app.exception.message.BundleMessage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class BaseException extends RuntimeException {

    static final long serialVersionUID = 969173814722558369L;

    @Getter
    private Set<ErrorData> errors;

    public BaseException() {
        super();
    }

    public BaseException(final Set<ErrorData> errors) {
        this.errors = errors;
    }

    public BaseException(final ErrorData... errors) {
        this.errors = Arrays.stream(errors).collect(Collectors.toSet());
    }

    public BaseException(final String message) {
        super(message);
    }

    public BaseException(final String message, final Set<ErrorData> errors) {
        super(message);
        this.errors = errors;
    }

    public BaseException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BaseException(final String message, final Throwable cause, final Set<ErrorData> errors) {
        super(message, cause);
        this.errors = errors;
    }

    public BaseException(final Throwable cause) {
        super(cause);
    }

    public BaseException(final Throwable cause, final Set<ErrorData> errors) {
        super(cause);
        this.errors = errors;
    }

    public BaseException(final String tag, final Throwable cause, final String[] args) {
        super(getMessage(tag, args), cause);
    }

    public BaseException(final String code, final String title, final String detail) {
        final var errorData = new ErrorData(title, detail, code);
        this.errors = new HashSet<>(Collections.singletonList(errorData));
    }

    private static String getMessage(final String tag, final String[] args) {
        return BundleMessage.getMessage(tag, args);
    }

}
