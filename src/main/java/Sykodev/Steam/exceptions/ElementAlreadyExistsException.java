package Sykodev.Steam.exceptions;

public class ElementAlreadyExistsException extends RuntimeException {

    public ElementAlreadyExistsException() { super("L'élément existe déjà");}
}
