package com.example.LeaveManagement.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="name",unique = true)
    private String name;
    @Column(name="projectname",unique = true,nullable = false)
    private String ProjectName;
    @Column(name="reportsTo")
    private String reportsTo;
    @Column(name="reportingmanager",nullable = false)
    private String ReportingManager;
    @Column(name="email",nullable = false)
    private String  useremail;

    public UserDetails() {
    }
    public UserDetails( String name, String ProjectName, String reportsTo, String ReportingManager,String useremail){
        this.name=name;
        this.ProjectName=ProjectName;
        this.reportsTo=reportsTo;
        this.ReportingManager=ReportingManager;
        this.useremail=useremail;
    }



    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ProjectName='" + ProjectName + '\'' +
                ", reportsTo='" + reportsTo + '\'' +
                ", ReportingManager='" + ReportingManager + '\'' +
                '}';
    }
}
