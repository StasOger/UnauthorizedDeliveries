package A1.Task3.model;

import javax.persistence.*;

@Entity
@Table(name = "logins")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "application")
    private String application;

    @Column(name = "appAccountName")
    private String appAccountName;

    @Column(name = "isActive")
    private boolean isActive;

    @Column(name = "jobTitle")
    private String jobTitle;

    @Column(name = "department")
    private String department;

    public User() {
    }

    public User(String application, String appAccountName, boolean isActive, String jobTitle, String department) {
        this.application = application;
        this.appAccountName = appAccountName;
        this.isActive = isActive;
        this.jobTitle = jobTitle;
        this.department = department;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getAppAccountName() {
        return appAccountName;
    }

    public void setAppAccountName(String appAccountName) {
        this.appAccountName = appAccountName;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", application='" + application + '\'' +
                ", appAccountName='" + appAccountName + '\'' +
                ", isActive='" + isActive + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
