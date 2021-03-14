package DataBase;

import CloudStorage.CloudStorageServer;
import io.netty.channel.ChannelHandlerContext;
import messages.AuthMessages;
import messages.CommandMessages;
import messages.Commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserAuthHandler {

    private final Map<String, ChannelHandlerContext> authorizedUsers;
    private final Connection connection;
    private final CloudStorageServer cloudStorageServer;

    public UserAuthHandler(CloudStorageServer cloudStorageServer) {
        authorizedUsers = new HashMap<>();
        connection = ConfigSqlDB.getConnection();
        this.cloudStorageServer = cloudStorageServer;
    }

    public boolean authorizeUser(CommandMessages commandMessages, ChannelHandlerContext ctx){

        AuthMessages authMessage = (AuthMessages) commandMessages.getObjectMessage();

        System.out.println(authMessage.getLogin());
        System.out.println(isUserAuthorized(authMessage.getLogin(), ctx) + "Логин есть или нет");

        if(isUserAuthorized(authMessage.getLogin(), ctx)){

            String message = "Пользователь с логином " + authMessage.getLogin() + " уже авторизирован";
            ctx.writeAndFlush(new CommandMessages(Commands.RESPONSE_SERVER_ERROR_MESSAGE, message));
            return false;
        }

        if(checkUserAuthorization(authMessage.getLogin(), authMessage.getPassword())){
            authorizedUsers.put(authMessage.getLogin(), ctx);
            printHashMap();
            return true;
        }

        String message = "Логин, пароль указаны неверно или такого пользователя не зарегестрировано";
        ctx.writeAndFlush(new CommandMessages(Commands.RESPONSE_SERVER_ERROR_MESSAGE, message));
        return false;
    }

    public boolean checkUserAuthorization(String login, String password) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Users WHERE Login = ? AND Password = ?");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }/*finally {
            *//*try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }*//*

        }*/
        return false;
    }

    public boolean isUserAuthorized(String login, ChannelHandlerContext ctx) {

        boolean isUserAuth = false;

        for (Map.Entry<String, ChannelHandlerContext> pair : authorizedUsers.entrySet()) {
            System.out.println(pair.getKey() + " ключ");
            isUserAuth = pair.getKey().equals(login);
        }
        return isUserAuth;
    }

    public Map<String, ChannelHandlerContext> getAuthorizedUsers() {
        return authorizedUsers;
    }

    public Connection getConnection() {
        return connection;
    }

    public void printHashMap () {
        for (Map.Entry<String, ChannelHandlerContext> pair : authorizedUsers.entrySet())
        {
            String key = pair.getKey();
            ChannelHandlerContext value = pair.getValue();
            System.out.println(key + ":" + value);
        }
    }
}
