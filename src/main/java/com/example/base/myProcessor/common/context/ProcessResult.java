package com.example.base.myProcessor.common.context;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
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

    public static class ProcessResultBuilder<T> {

        private T data;

        private Boolean isSuccess;

        public ProcessResult.ProcessResultBuilder data(T data) {
            this.data = data;
            return this;
        }

        public ProcessResult.ProcessResultBuilder isSuccess(Boolean isSuccess) {
            this.isSuccess = isSuccess;
            return this;
        }

        public ProcessResult build() {
            return new ProcessResult(this.data, this.isSuccess);
        }
    }


}
