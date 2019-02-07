package db;

public class UsersDBException extends Throwable {
    public UsersDBException(String s, Exception e) {
        super(s, e);
    }

    public UsersDBException(String s) {
        super(s);
    }
}
