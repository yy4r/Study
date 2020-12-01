package com.example.demo.myProcessor.context;

import lombok.Data;

@Data
public class ProcessResult<T> {

    private T data;

    private Boolean isSuccess;

    public ProcessResult(T data) {
        this.data = data;
    }

    public ProcessResult(T data, Boolean isSuccess) {
        this.data = data;
        this.isSuccess = isSuccess;
    }

    public ProcessResult(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }


}
