package com.whsoft.sv.educacacion.service;

import com.whsoft.sv.educacacion.domain.entity.StudentEntity;
import com.whsoft.sv.educacacion.domain.repository.StudentRepository;
import com.whsoft.sv.educacacion.dto.StudentDto;
import com.whsoft.sv.educacacion.utils.UtilsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;

import static com.whsoft.sv.educacacion.utils.Constants.FORMAT_DATE;
import static com.whsoft.sv.educacacion.utils.Constants.FORMAT_DATE_BIRTH_DATE;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private final ModelMapper modelMapper;

    private final UtilsService utilsService;


    public StudentDto studentCreate(StudentDto studentDto) throws ParseException {
        StudentEntity studentEntity=modelMapper.map(studentDto,StudentEntity.class);
        studentEntity.setCreated(new Date());
        studentEntity.setBirthdate(utilsService.StringToDate(studentDto.getBirth(),FORMAT_DATE_BIRTH_DATE));
        studentEntity=studentRepository.saveAndFlush(studentEntity);
        studentDto.setId(studentEntity.getId());
        studentDto.setBirth(utilsService.dateToString(studentEntity.getBirthdate(),FORMAT_DATE_BIRTH_DATE));
        return studentDto;
    }



}
