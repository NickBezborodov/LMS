package com.example.lms.controller;

import com.example.lms.dao.TeacherRepository;
import com.example.lms.dto.TeacherDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TeacherControllerTest {
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("lms-pg")
            .withUsername("test")
            .withPassword("test");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TeacherRepository teacherRepository;

    @BeforeEach
    void setUp() {
        teacherRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        teacherRepository.deleteAll();
    }

    @Test
    void getAllTeachers() {
        TeacherDto dto = TeacherDto.builder()
                .firstName("Вангог")
                .lastName("Вангогович")
                .build();
        restTemplate.postForEntity("http://localhost:" + port + "/api/v1/teachers", dto, TeacherDto.class);

        TeacherDto dto1 = TeacherDto.builder()
                .firstName("Ашот")
                .lastName("Пашотович")
                .build();
        restTemplate.postForEntity("http://localhost:" + port + "/api/v1/teachers", dto1, TeacherDto.class);

        TeacherDto[] teachers = restTemplate.getForObject(
                "http://localhost:" + port + "/api/v1/teachers", TeacherDto[].class);

        assertEquals(2, teachers.length);
    }

    @Test
    void addTeacher() {
        TeacherDto dto = TeacherDto.builder()
                .firstName("Петр")
                .lastName("Петров")
                .build();

        ResponseEntity<TeacherDto> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/v1/teachers", dto, TeacherDto.class);

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Петр", response.getBody().getFirstName());
    }

    @Test
    void updateTeacher() {
        TeacherDto dto = TeacherDto.builder()
                .firstName("Петр")
                .lastName("Петров")
                .build();
        ResponseEntity<TeacherDto> response =  restTemplate.postForEntity(
                "http://localhost:" + port + "/api/v1/teachers", dto, TeacherDto.class);

        Long id = response.getBody().getId();
        TeacherDto updatedDto = TeacherDto.builder()
                .firstName("Альберт")
                .lastName("Коровкин")
                .build();

        restTemplate.put(
                "http://localhost:" + port + "/api/v1/teachers/" + id, updatedDto);

        TeacherDto result = restTemplate.getForObject(
                "http://localhost:" + port + "/api/v1/teachers/" + id, TeacherDto.class);

        assertNotNull(result);
        assertEquals("Альберт", result.getFirstName());
        assertEquals("Коровкин", result.getLastName());
    }

    @Test
    void deleteTeacher() {
        TeacherDto dto = TeacherDto.builder()
                .firstName("Петр")
                .lastName("Петров")
                .build();
        ResponseEntity<TeacherDto> response =  restTemplate.postForEntity(
                "http://localhost:" + port + "/api/v1/teachers", dto, TeacherDto.class);
        Long id = response.getBody().getId();

        restTemplate.delete(
                "http://localhost:" + port + "/api/v1/teachers/" + id);
    }
}
