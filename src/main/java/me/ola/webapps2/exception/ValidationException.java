package me.ola.webapps2.exception;

/**
 * Ошибка валидации
 */
public class ValidationException extends RuntimeException{
    public ValidationException (String entity) {
        super("Ошибка валидации сущности: " + entity);
    }
}
