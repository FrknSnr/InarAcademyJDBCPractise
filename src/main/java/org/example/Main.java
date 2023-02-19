package org.example;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try{
            Question.answer();
        }
        catch (SQLException ex){
            System.out.println(ex);
        }

    }
}