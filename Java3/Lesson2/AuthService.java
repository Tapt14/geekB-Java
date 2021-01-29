package Java3.Lesson2;

public interface AuthService {
    void start();
    void stop();
    Users getNickByLoginAndPass(String login, String password);
}
