package com.example.LeaveManagement.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


@Getter
@Setter
public class UserRequest {
    @NotEmpty(message = "id cannot be null")
    private int id;
    @NotEmpty(message = "name cannot be null")
    private String name;
    @NotEmpty(message = "not null")
    private String ProjectName;
    private String reportsTo;
    @NotEmpty(message="not null")
    private String ReportingManager;

}
