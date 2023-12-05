package com.gte3.mongodemo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@SpringBootTest
public class StudentServiceImplementationTest {
    @MockBean
    private StudentRepository studentRepository;

    @Autowired
    private StudentServiceImplementation studentService;

    @Test
    public void testCreateStudent() {
        // Mock repository behavior
        when(studentRepository.save(new Student("ichebncdhcz2",111111111, "John","john@example.com",25896547)))
                .thenReturn(new Student("ichebncdhcz2",111111111, "John","john@example.com",25896547));

        // Call the service method
        String result = studentService.createStudent(new Student("ichebncdhcz2",111111111, "John","john@example.com",25896547));

        // Verify that the repository's save method is called with the correct arguments
        verify(studentRepository).save(new Student("ichebncdhcz2",111111111, "John","john@example.com",25896547));

        // Assert the result
        assertEquals("Student created Successfully", result);
    }

    // Add more test methods for other service operations
}
