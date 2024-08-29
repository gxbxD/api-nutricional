package online.nutritabapi.api_nutricional.exceptions;

public class AlimentoNotFoundException extends RuntimeException {
    public AlimentoNotFoundException(String message) {
        super(message);
    }
}