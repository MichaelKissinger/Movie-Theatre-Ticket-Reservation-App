package model;

import java.util.Date;

public class Email {

    private int emailId;
    private int userId;
    private String message;
    private Date sentDate;
    private String subject;
    private Boolean read;

    public Email(String message, String subject, Date sentDate)
    {
        setMessage(message);
        setSubject(subject);
        setSentDate(sentDate);
        setRead(false);
    }

    public int getEmailId() {
        return emailId;
    }

    public void setEmailId(int emailId) {
        this.emailId = emailId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }
}
