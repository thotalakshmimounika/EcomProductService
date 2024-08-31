package dev.mounika.EcomProductService.exception;

import dev.mounika.EcomProductService.Controller.ProductController;
import dev.mounika.EcomProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ProductControllerExceptionHandler {

    @ExceptionHandler({ProductnotFoundException.class,NoProductPresentException.class})
    public ResponseEntity handleProductNotFoundException(ProductPresentException pe){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO
                (pe.getMessage(),404);
        return new ResponseEntity(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity handleInvalidInputException(InvalidInputException ipe){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO
                (ipe.getMessage(),404);
        return new ResponseEntity(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RandomException.class)
    public ResponseEntity handleProductRandomException(RandomException pe){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO
                (pe.getMessage(),404);
        return new ResponseEntity(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }
}
