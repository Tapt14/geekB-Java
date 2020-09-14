package Java3.Lesson3;

public interface AuthService {
    void start();
    void stop();
    Users getNickByLoginAndPass(String login, String password);
}
