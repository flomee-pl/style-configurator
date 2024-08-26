package pl.flomee.styleconfigurator.domain.outfit.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Outfit Not Found")
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Outfit Not Found");
    }
}
