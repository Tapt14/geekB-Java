package messages;

public class AuthMessages extends Message{
    private final String login;
    private final String password;

    public AuthMessages(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
