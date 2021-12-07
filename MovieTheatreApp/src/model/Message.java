
package model;

import java.util.Date;

public class Message {

    private int messageID;
    private int userID;
    private String message;
    private Date sentDate;
    private String subjectLine;
    private Boolean readStatus;

    public Message(int userID, String message, String subjectLine, Date sentDate)
    {
        setUserID(userID);
        setMessage(message);
        setSubjectLine(subjectLine);
        setSentDate(sentDate);
        setReadStatus(false);
    }

    public Message()
    {}

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public String getSubjectLine() {
        return subjectLine;
    }

    public void setSubjectLine(String subjectLine) {
        this.subjectLine = subjectLine;
    }

    public Boolean getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Boolean readStatus) {
        this.readStatus = readStatus;
    }
}

