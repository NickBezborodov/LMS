package com.example.lms.exception;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException (String message){
        super(message);
    }
}
/* exception
Класс	Аннотации
Исключения	Без аннотаций, extends RuntimeException

Методы-обработчики	@ExceptionHandler(...), @ResponseStatus(HttpStatus.NOT_FOUND) */