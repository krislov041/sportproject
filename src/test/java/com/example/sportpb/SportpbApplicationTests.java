package com.example.sportpb;

import com.example.sportpb.entity.Sportevent;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootTest
class SportpbApplicationTests {

    @Test
    void contextLoads() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/sportdb";
        String user = "root";
        String password = "12345678abcd";
        java.sql.Connection myConnection = DriverManager.getConnection(url,user,password);
        Statement mystatement = myConnection.createStatement();
        ResultSet rs = mystatement.executeQuery(" select * from sportevent");
        while(rs.next()) {
            String fn = rs.getString("s_id");
            String fa = rs.getString("s_Name");
            String fb = rs.getString("s_Time");
            String fc = rs.getString("s_Result");


            System.out.println(fn+""+fa+""+fb+""+fc);
        }



    }



}
