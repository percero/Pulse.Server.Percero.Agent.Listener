package com.pulse.auth.vo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Class to represent the response from the Pulse /retrieve_user endpoint
 * Created by Jonathan Samples on 8/27/15.
 * 
 * Example:
{
  "UserId": "Sylvia.Devore@convergys.com",
  "EmployeeId": "100735650",
  "Name": "Sylvia Devore",
  "IsManager": false,
  "IsAgent": false,
  "IsTL": true,
  "Email": "Sylvia.Devore@convergys.com",
  "Title": null,
  "PersonId": null,
  "FirstName": null,
  "Initials": null,
  "LastName": null,
  "DisplayName": null,
  "Description": null,
  "SafeLastName": "",
  "SafeDisplayName": " ",
  "Id": 0
}
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class PulseUserInfo {
    @JsonProperty(value="UserId")
    private String userLogin;
    @JsonProperty(value="EmployeeId")
    private String employeeId;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
}
