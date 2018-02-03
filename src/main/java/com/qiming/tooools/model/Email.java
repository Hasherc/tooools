package com.qiming.tooools.model;

import java.util.Map;

/**
 * @tooools
 * @Description:
 * @Author: qming_c
 * @Date: 2018-02-03-22:30
 */
public class Email {
    private int id;
    private String to;
    private int emailtype;
    private String templateName;
    private String toName;
    private String fromName;
    private String description;
    private String subject;
    private Map<String, Object> model;

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", to=" + to +
                ", emailType=" + emailtype +
                ", templateName='" + templateName + '\'' +
                ", toName='" + toName + '\'' +
                ", fromName='" + fromName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getEmailtype() {
        return emailtype;
    }

    public void setEmailtype(int emailtype) {
        this.emailtype = emailtype;
    }


    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
}
