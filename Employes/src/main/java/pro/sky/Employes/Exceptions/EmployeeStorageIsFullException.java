package pro.sky.Employes.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.LENGTH_REQUIRED)
public class EmployeeStorageIsFullException extends  RuntimeException{
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
