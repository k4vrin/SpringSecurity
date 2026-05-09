package dev.kavrin.SpringSecurity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/students"))
public class StudentController {

    private List<Student> students = List.of(
            new Student(1, "Alice", 85),
            new Student(2, "Bob", 90),
            new Student(3, "Charlie", 78)
    );

    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping(path = "/csrf-token")
    public CsrfToken getToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}
