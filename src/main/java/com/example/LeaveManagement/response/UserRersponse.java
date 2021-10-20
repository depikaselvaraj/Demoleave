package com.example.LeaveManagement.response;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UserRersponse {
    @NotEmpty(message = "id cannot be null")
    private int id;
    @NotEmpty(message = "name cannot be null")
    private String name;
    private String ProjectName;
    private String reportsTo;
    private String ReportingManager;
}
