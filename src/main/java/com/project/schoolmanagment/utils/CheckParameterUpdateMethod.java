package com.project.schoolmanagment.utils;

import com.project.schoolmanagment.entity.abstracts.User;
import com.project.schoolmanagment.payload.request.abstracts.BaseUserRequest;

public class CheckParameterUpdateMethod {


    public static boolean checkUniqueProperties(User user, BaseUserRequest baseUserRequest){

        return user.getSsn().equalsIgnoreCase(baseUserRequest.getSsn())
                || user.getPhoneNumber().equalsIgnoreCase(baseUserRequest.getPhoneNumber())
                || user.getUsername().equalsIgnoreCase(baseUserRequest.getUsername());
    }

}
