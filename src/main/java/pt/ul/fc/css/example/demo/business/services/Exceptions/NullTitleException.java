package pt.ul.fc.css.example.demo.business.services.Exceptions;

import pt.ul.fc.css.example.demo.business.services.Exceptions.ApplicationException;

public class NullTitleException extends ApplicationException {

    public NullTitleException(String message) {
        super(message);
    }
}
