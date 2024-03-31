package Lectorarchivos.Reader.model;
import com.opencsv.bean.CsvBindByName;

import java.io.Serializable;

public class CsvInformation {
    @CsvBindByName(column = "Index")
    private String index;
    @CsvBindByName(column = "User Id")
    private String userId;
    @CsvBindByName(column = "First Name")
    private String firstname;
    @CsvBindByName(column = "Last Name")
    private String lastname;
    @CsvBindByName(column = "Sex")
    private String sex;
    @CsvBindByName(column = "Email")
    private String email;
    @CsvBindByName(column = "Phone")
    private String phone;
    @CsvBindByName(column = "Date of birth")
    private String date;
    @CsvBindByName(column = "Job Title")
    private String jobTitle;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "CsvInformation{" +
                "index='" + index + '\'' +
                ", userId='" + userId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", date='" + date + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
