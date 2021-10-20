package com.example.LeaveManagement.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
public class LeaveRequest {
    @NotEmpty(message="leave id cannot be null")
    private int leaveid;
    @NotEmpty(message="employeeid cannot be null")
    private int empid;
    @NotEmpty(message="name cannot be null")
    private String name;
    @NotEmpty(message="date must be there")
    private Date startDate;
    @NotEmpty(message="date must be there")
    private Date EndDate;
    private String Reason;
    private String ProjectName;
    private String Approver;
}
