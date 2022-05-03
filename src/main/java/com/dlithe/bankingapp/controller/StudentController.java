package com.dlithe.bankingapp.controller;


import com.dlithe.bankingapp.dto.BaseResponse;
import com.dlithe.bankingapp.dto.StudentDetailsRequest;
import com.dlithe.bankingapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("register-student-details")
    public String registerNewUser(@RequestBody StudentDetailsRequest studentDetailsRequest){
        return studentService.registerNewUser(studentDetailsRequest);
    }

    @GetMapping("fetch-student-details/{studentId}")
    public ResponseEntity<BaseResponse> getStudentDetails(@PathVariable int studentId){

        if(studentId == 0 || String.valueOf(studentId)==null){
           // return new ResponseEntity<BaseResponse>(new BaseResponse("Student id cannot be zero null", HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(),null));
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("Student id cannot be zero null");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());

            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return studentService.findStudentDetails(studentId);
    }
}
