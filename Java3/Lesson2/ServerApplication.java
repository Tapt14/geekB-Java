package Java3.Lesson2;

public class ServerApplication {
    public static void main(String[] args) {
        //System.out.println(new ChatHistory().loadLastOneHundredLines());
        new Server(8564);
    }
}
