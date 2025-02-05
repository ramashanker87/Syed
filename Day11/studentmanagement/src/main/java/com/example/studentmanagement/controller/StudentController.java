package com.example.studentmanagement.controller;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/student")
public class StudentController {
  private StudentService studentService;
  public StudentController(StudentService studentService) {
      this.studentService = studentService;
  }
  @PostMapping("/save")
    public ResponseEntity save(@RequestBody Student student) {
      return ResponseEntity.ok(studentService);
  }
  @PostMapping("/save")
    public ResponseEntity saveStudent(@RequestBody Student student) {
      return ResponseEntity.ok(studentService.saveStudent(student));

  }
  @GetMapping("/read")
    public ResponseEntity<List<Student>> getAllStudents() {
      return ResponseEntity.ok(studentService.getAllStudents());
  }
}
