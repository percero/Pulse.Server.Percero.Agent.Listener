package com.pulse.auth.service;

import com.percero.agents.auth.vo.AuthCode;

/**
 * Created by jonnysamps on 10/19/15.
 */
public class PulseAuthCode extends AuthCode{

    public static final PulseAuthCode BAD_USER_PASS = new PulseAuthCode(433, "Bad username or password");
    public static final PulseAuthCode NO_TEAM_LEADER = new PulseAuthCode(443, "Team Leader not found");
    public static final PulseAuthCode EMPLOYEEID_NOT_FOUND = new PulseAuthCode(453, "Employee ID not found");
    public static final PulseAuthCode RETRIEVE_USER_FAILED = new PulseAuthCode(501, "Call to retrieve_user failed");

    private PulseAuthCode(int code, String message){
        super(code, message);
    }
}
