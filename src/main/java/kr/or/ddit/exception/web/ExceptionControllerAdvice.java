package kr.or.ddit.exception.web;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.exception.NoFileException;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler({ArithmeticException.class})
	public String exceptionHandler() {
		return "error/arithmetic";
	}
	
	
	
}
