package com.supportwheelfate.supportwheeloffate.response;

public class GETResponse {
    private boolean status;
    private Object results;
    private String[] errors;

    public GETResponse(boolean status, String[] errors) {
        this.status = status;
        this.errors = errors;
    }

    public GETResponse(boolean status, Object results) {
        this.status = status;
        this.results = results;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getResults() {
        return results;
    }

    public void setResults(Object results) {
        this.results = results;
    }

    public String[] getErrors() {
        return errors;
    }

    public void setErrors(String[] errors) {
        this.errors = errors;
    }
}
