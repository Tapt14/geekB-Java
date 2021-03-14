package NettyServer;

import DataBase.ConfigSqlDB;
import io.netty.channel.ChannelHandlerContext;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Test {

    static Map<String, String> map = new HashMap<>();


    public static void printHashMap () {
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " : " + value);
        }
    }

    public static boolean checkMap (String s) {

        boolean isCheck = false;

        for (Map.Entry<String, String> pair : map.entrySet())
        {
            //String key = pair.getKey();
            if (pair.getKey().equals(s)) isCheck = true;

            //String value = pair.getValue();
            //System.out.println(key + " : " + value);
            }
        return isCheck;
    }

    public static void main(String[] args) {
        map.put("User1", "Pass1");
        map.put("User2", "Pass2");
        map.put("User3", "Pass3");

        printHashMap();

        System.out.println(checkMap("User1"));

    }

}
