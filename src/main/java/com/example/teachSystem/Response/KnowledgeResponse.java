package com.example.teachSystem.Response;

import com.example.teachSystem.formbean.KnowledgeForm;

public class KnowledgeResponse {
    private int code;
    private String message;
    private KnowledgeForm data;

    public KnowledgeResponse(int code, String message, KnowledgeForm data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public KnowledgeForm getData() {
        return data;
    }

    public void setData(KnowledgeForm data) {
        this.data = data;
    }
}
