package com.example.lms.controller;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/lms")
@RestController
@RequiredArgsConstructor
public class CourseController {
}
/* Методы GET	@GetMapping
Методы POST	@PostMapping, параметр @Valid @RequestBody
Методы PUT	@PutMapping("/{id}"), @PathVariable, @Valid @RequestBody
Методы DELETE	@DeleteMapping("/{id}"), @PathVariable */