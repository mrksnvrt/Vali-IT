package ee.bcs.valiit.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Table(name = "employee")
//@Entity

public class EmployeeData {
    //@Id
    private String first_name;
    private String last_name;
    private Integer birth_year;
    private String job_title;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(Integer birth_year) {
        this.birth_year = birth_year;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }
}

