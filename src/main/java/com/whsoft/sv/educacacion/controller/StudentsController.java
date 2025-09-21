package com.whsoft.sv.educacacion.controller;

import com.whsoft.sv.educacacion.dto.StudentDto;
import com.whsoft.sv.educacacion.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentsController {

 private final StudentService studentService;



  @PostMapping(path = "/api/v1/create")
  public ResponseEntity<Object> createStudent(@RequestBody StudentDto request) throws ParseException {
       StudentDto res=null;
       try{
           res=studentService.studentCreate(request);
       }catch (Exception e){
           throw  e;
       }
      return ResponseEntity.ok(res);

  }



}
