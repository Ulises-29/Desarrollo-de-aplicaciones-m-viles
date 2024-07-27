package com.gsoft.univer.model.response;

public class Notificacion {
    private String message;
    private String level;
    private String reason;

    public Notificacion() {
    }

    public Notificacion(String message, String level, String reason) {
        this.message = message;
        this.level = level;
        this.reason = reason;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
