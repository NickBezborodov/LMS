package com.example.lms.exception;

public class CourseNotFoundException {
}
/* exception
Класс	Аннотации
Исключения	Без аннотаций, extends RuntimeException
GlobalExceptionHandler	@RestControllerAdvice
Методы-обработчики	@ExceptionHandler(...), @ResponseStatus(HttpStatus.NOT_FOUND) */