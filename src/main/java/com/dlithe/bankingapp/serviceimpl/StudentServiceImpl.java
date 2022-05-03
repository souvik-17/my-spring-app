package com.dlithe.bankingapp.serviceimpl;


import com.dlithe.bankingapp.dto.BaseResponse;
import com.dlithe.bankingapp.dto.StudentDetailsRequest;
import com.dlithe.bankingapp.entity.Student;
import com.dlithe.bankingapp.repository.StudentDAO;
import com.dlithe.bankingapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;


    @Override
    public String registerNewUser(StudentDetailsRequest studentDetailsRequest) {

        Student student = new Student();
        student.setName(studentDetailsRequest.getName());
        student.setAge(studentDetailsRequest.getAge());
        student.setGender(studentDetailsRequest.getGender());

        studentDAO.save(student);
        return "Student details saved successfully";

    }

    @Override
    public ResponseEntity<BaseResponse> findStudentDetails(int studentId) {

        BaseResponse baseResponse = new BaseResponse();
        StudentDetailsRequest studentDetailsRequest = new StudentDetailsRequest();

        Optional<Student> student = studentDAO.findById(studentId);
        if(!student.isPresent()){
            baseResponse.setMessage("Student for the given Id is not present");
            baseResponse.setHttpStatus(HttpStatus.NOT_FOUND);
            baseResponse.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
            baseResponse.setResponse(studentDetailsRequest);

            return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.NOT_FOUND);

        }
        Student studentData = student.get();
        studentDetailsRequest.setName(studentData.getName());
        studentDetailsRequest.setAge(studentData.getAge());
        studentDetailsRequest.setGender(studentData.getGender());

        baseResponse.setMessage("Fetch Student information successfully");
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());
        baseResponse.setResponse(studentDetailsRequest);

        return new ResponseEntity<BaseResponse>(baseResponse,HttpStatus.OK);
    }
}
