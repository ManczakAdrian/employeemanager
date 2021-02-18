package pl.manczak.employeemanager.exception;

public class UserNotFoundEception extends RuntimeException{
    public UserNotFoundEception(String message) {
        super(message);
    }
}
