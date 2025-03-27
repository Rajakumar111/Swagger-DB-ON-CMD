package com.practic.Ram.payload;

import java.util.Date;

public class ErrorDedails {

    public Date date;
    public String message;
    public String description;

    public ErrorDedails(Date date, String message, String description) {
        this.date = date;
        this.message = message;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
