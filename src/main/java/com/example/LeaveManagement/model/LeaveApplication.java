package com.example.LeaveManagement.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class LeaveApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leaveid;
    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name="id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserDetails user;
    @Column(name="employeename")
    private String name;
    @Column(name="SDate")
    private Date startDate;
    @Column(name="EDate")
    private Date EndDate;
    @Column(name="reason")
    private String Reason;
    @Column(name="projectname")
    private String ProjectName;
    @Column(name="approver")
    private String Approver;



    public LeaveApplication(int leaveid, UserDetails user, String name, Date startDate, Date endDate, String reason, String projectName, String approver) {
        this.leaveid = leaveid;
        this.user=user;
        this.name = name;
        this.startDate = startDate;
        EndDate = endDate;
        Reason = reason;
        ProjectName = projectName;
        Approver = approver;
    }

}
