package com.jdbcCourse;

// 1. import sql package

import java.sql.*;

public class DemoJdbc {
    public static void main(String[] args) {
        /*
            JDBC Steps:

            1. import package
            2. load and register
            3. create connection
            4. create statement
            5. execute statement
            6. process the results
            7. close connection
         */

        int sid = 110, marks = 70;
        String sname = "Max";

        try{
            // 2. load and register
            Class.forName("org.postgresql.Driver");

            // 3. create connection
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Demo","postgres", "root");
            System.out.println("Connection Established..!");

            // 4. create statement
            // Statement st = con.createStatement(); //This is a Statement
            // String query = "SELECT * FROM \"Student\" ;"; //This is a Statement

            String query = "INSERT INTO \"Student\" VALUES (?,?,?);"; //This is a Prepared Statement
            PreparedStatement pst = con.prepareStatement(query); //This is a Prepared Statement

            // 5. execute statement
            //ResultSet rs = st.executeQuery(query); //This is a Statement

            pst.setInt(1, sid); //This is a Prepared Statement
            pst.setString(2, sname);
            pst.setInt(3, marks);

            pst.execute();

            // 6. process the results
//            while(rs.next()) {
//                sid = rs.getInt("sid");
//                sname = rs.getString("sname");
//                marks = rs.getInt("marks");
//                System.out.println(sid + " - " + sname + " - " + marks);
//            }

            // 7. close connection
            con.close();
            System.out.println("Connection Closed");
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }
}