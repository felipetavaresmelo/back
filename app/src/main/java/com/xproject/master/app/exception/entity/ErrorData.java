package com.xproject.master.app.exception.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ErrorData implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
    private String code;
    private String detail;
    private LocalDateTime dateError;

    public ErrorData(final String title, final String detail, final String code) {
        this.title = title;
        this.detail = detail;
        this.code = code;
    }

    public ErrorData(final String title, final String detail) {
        this.title = title;
        this.detail = detail;
    }

    public ErrorData(final ErrorData errorData) {
        this.detail = errorData.detail;
        this.title = errorData.title;
        this.code = errorData.code;
        this.dateError = errorData.dateError;
    }

    public ErrorData(String title, String code, String detail, LocalDateTime dateError) {
        this.title = title;
        this.code = code;
        this.detail = detail;
        this.dateError = dateError;
    }
}
