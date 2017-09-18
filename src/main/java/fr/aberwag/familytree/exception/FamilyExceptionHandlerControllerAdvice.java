package fr.aberwag.familytree.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import fr.aberwag.familytree.domain.ExceptionMessage;

@RestControllerAdvice
public class FamilyExceptionHandlerControllerAdvice {

	public static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

	@ExceptionHandler(FamilyBusinessException.class)
	public ExceptionMessage familyBusinessException(HttpServletRequest request, FamilyBusinessException exception) {
		ExceptionMessage message = new ExceptionMessage();
		message.setDate(LocalDateTime.now().format(formatter));
		message.setClassName(exception.getClass().getName());
		message.setMessage("message d'erreur geré par @ExceptionHandler");
		message.setPath(request.getRequestURI().toString());

		return message;
	}

	@ExceptionHandler(NullPointerException.class)
	public ExceptionMessage nullPointerExceptionHandler(HttpServletRequest request, NullPointerException exception) {
		ExceptionMessage message = new ExceptionMessage();
		message.setDate(LocalDateTime.now().format(formatter));
		message.setDate(request.getRequestURI().toString() + "?" + request.getQueryString());
		message.setClassName(exception.getClass().getName());
		message.setMessage(
				"Tu veux éviter les null ? N'hésite pas à lire cet article: https://www.developpez.net/forums/blogs/473169-gugelhupf/b2944/java-astuces-eviter-nullpointerexception/");
		return message;
	}
}