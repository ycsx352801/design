package com.bean;

import java.util.Date;

public class Applicant {
    private Integer applicantId;//id
    private String applicantEmail;//邮箱
    private String applicantPwd;//密码
    private Date applicantRegistdate;//注册时间

    public Applicant(Integer applicantId, String applicantEmail, String applicantPwd, Date applicantRegistdate) {
        this.applicantId = applicantId;
        this.applicantEmail = applicantEmail;
        this.applicantPwd = applicantPwd;
        this.applicantRegistdate = applicantRegistdate;
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getApplicantPwd() {
        return applicantPwd;
    }

    public void setApplicantPwd(String applicantPwd) {
        this.applicantPwd = applicantPwd;
    }

    public Date getApplicantRegistdate() {
        return applicantRegistdate;
    }

    public void setApplicantRegistdate(Date applicantRegistdate) {
        this.applicantRegistdate = applicantRegistdate;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "applicantId=" + applicantId +
                ", applicantEmail='" + applicantEmail + '\'' +
                ", applicantPwd='" + applicantPwd + '\'' +
                ", applicantRegistdate=" + applicantRegistdate +
                '}';
    }
}
