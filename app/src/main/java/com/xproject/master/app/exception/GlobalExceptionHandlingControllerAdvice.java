package com.xproject.master.app.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandlingControllerAdvice {

    protected Logger logger;

    public GlobalExceptionHandlingControllerAdvice() {
        logger = LoggerFactory.getLogger(getClass());
    }


    @ExceptionHandler({EntityNotFoundException.class, NoSuchElementException.class})
    public ResponseEntity<String> handleEntityNotFoundException(HttpServletRequest req, Exception exception) {

        if (AnnotationUtils.findAnnotation(exception.getClass(), ResponseStatus.class) != null)
            return ResponseEntity.notFound().build();

        logger.error(MessageFormat.format("Request: {0} raised {1}", req.getRequestURI(), exception));

        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleError(HttpServletRequest req, Exception exception) {

        if (AnnotationUtils.findAnnotation(exception.getClass(), ResponseStatus.class) != null)
            return ResponseEntity.internalServerError().body(exception.toString());

        logger.error(MessageFormat.format("Request: {0} raised {1}", req.getRequestURI(), exception));

        return ResponseEntity.internalServerError().body(exception.toString());
    }
}
