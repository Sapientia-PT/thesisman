package pt.ul.fc.css.example.demo.business.services.Exceptions;

public class UserAlreadyExistsException extends ApplicationException {
  public UserAlreadyExistsException(String message) {
    super(message);
  }
}
