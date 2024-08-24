package pl.flomee.styleconfigurator.outfit.application;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class CustomErrorController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException exception) {

        Map<String, String> errorMap =
            exception.getFieldErrors().stream()
                .collect(
                    HashMap::new,
                    (map, fieldError) ->
                        map.put(fieldError.getField(),
                            fieldError.getDefaultMessage()),
                    HashMap::putAll
                );
        return errorMap;
    }

    @ExceptionHandler(InvalidFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleValidationExceptions(InvalidFormatException exception) {
        List<String> validValues = Arrays.stream(exception.getTargetType().getEnumConstants())
            .map(Object::toString)
            .toList();

        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put(exception.getTargetType().getSimpleName().toLowerCase(), "Invalid value");
        errorMap.put("validValues", validValues);

        return errorMap;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFoundException(NotFoundException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", exception.getMessage());
        return errorMap;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message",
            "Invalid value for parameter " +
                exception.getName() +
                " required type "
                + exception.getRequiredType().getSimpleName());
        return errorMap;
    }
}
