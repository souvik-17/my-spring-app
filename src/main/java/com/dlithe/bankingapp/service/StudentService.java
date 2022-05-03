package com.dlithe.bankingapp.service;

import com.dlithe.bankingapp.dto.BaseResponse;
import com.dlithe.bankingapp.dto.StudentDetailsRequest;
import org.springframework.http.ResponseEntity;

public interface StudentService {

   String registerNewUser(StudentDetailsRequest studentDetailsRequest);

   ResponseEntity<BaseResponse> findStudentDetails(int studentId);
}
