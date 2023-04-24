package com.example.teachSystem.Response;

import com.example.teachSystem.formbean.CourseForm;

public class CourseResponse {
    private int status;
    private String message;
    private CourseForm course;

    public CourseResponse() {
    }

    public CourseResponse(int status, String message, CourseForm course) {
        this.status = status;
        this.message = message;
        this.course = course;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CourseForm getCourse() {
        return course;
    }

    public void setCourse(CourseForm course) {
        this.course = course;
    }
}
