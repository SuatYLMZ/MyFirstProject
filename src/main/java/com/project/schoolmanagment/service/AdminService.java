package com.project.schoolmanagment.service;

import com.project.schoolmanagment.payload.request.abstracts.AdminRequest;
import com.project.schoolmanagment.payload.response.ResponseMessage;
import org.springframework.stereotype.Service;

@Service
public class AdminService {


    public ResponseMessage save(AdminRequest adminRequest){

        return null;
    }
    // As a requirement all Admin, ViceAdmin, Dean, Student, Teacher, GuestUser
    // should have unique userName, email, ssn and phone number

}
