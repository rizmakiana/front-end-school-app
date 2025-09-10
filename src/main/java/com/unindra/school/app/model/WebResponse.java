package com.unindra.school.app.model;

public class WebResponse<T> {

    private T data;

    private String message;
    
    private Object errors;

    private PagingResponse pagingResponse;

    public T getData() {
        return data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getErrors() {
        return errors;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
    }

    public PagingResponse getPagingResponse() {
        return pagingResponse;
    }

    public void setPagingResponse(PagingResponse pagingResponse) {
        this.pagingResponse = pagingResponse;
    }
    
}
