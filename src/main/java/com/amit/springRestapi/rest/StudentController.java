package com.amit.springRestapi.rest;
import com.amit.springRestapi.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private List<Student> theStudents;

    // difinr@postcontructor
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Poojara", "patel"));
        theStudents.add(new Student("Pujara", "patel"));
        theStudents.add(new Student("Loojara", "patel"));


    }
    //

    @GetMapping("/students")

    public List<Student> getStudent() {
        //List<Student> theStudents=new ArrayList<>();
//        theStudents.add(new Student("Poojara","patel"));
//        theStudents.add(new Student("Pujara","patel"));
//        theStudents.add(new Student("Loojara","patel"));

        return theStudents;
    }

    //definr end point or "/Student/{studentId} - return at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        //just index into the list .....keep it simple for now
        //check the student Id again list size
        if((studentId>= theStudents.size()||(studentId<0)))
        {
            throw new StudentNotFoundException("student is not found.."+studentId);
        }

        return theStudents.get(studentId);

    }
    //add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse>handleException(StudentNotFoundException exc)
    {
        //create a StudentErrorResponse
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

     return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }
    //add another exception  handler ... to catch any exception(catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse>handleException(Exception exc)
    {
        //crete a StudentErrorResponse
        StudentErrorResponse error =new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}