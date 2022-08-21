package com.example.demo.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getStudents() {

        return studentRepository.findAll();
    //     return Arrays.asList(
    //             new Student(
    //                     "Chetan",
    //                     "chetan@gmail.con",
    //                     LocalDate.of(1988, Month.JUNE, 5),
    //                     21));
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail =  studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        System.out.println(student);
        studentRepository.save(student);
    }
}
