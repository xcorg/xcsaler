package models;

public interface IUser {

    public Long getId();

    public String getName();

    public String getUsername();

    public boolean passwordMatches(String password);

    public void setPassword(String password);

    public UserType getType();

    public enum UserType {
        User, Admin, Company, NOT_LOGGED_IN
    }
}
