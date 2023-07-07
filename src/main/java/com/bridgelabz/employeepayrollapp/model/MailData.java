package com.bridgelabz.employeepayrollapp.model;

import lombok.Data;

@Data
public class MailData {
    private String toEmail;
    private String body;
    private String subject;
    private String attachment;
}
