package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UsersDB {

    private Connection connectToPostgreSQL() throws SQLException, UsersDBException {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            Connection connection = null;
            DriverManager.setLoginTimeout(60);
            String url = new StringBuilder()
                    .append("jdbc:")
                    .append("postgresql")       // “mysql” / “db2” / “mssql” / “oracle” / ...
                    .append("://")
                    .append("localhost")
                    .append(":")
                    .append(5432)
                    .append("/")
                    .append("?user=")
                    .append("postgres")
                    .append("&password=")
                    .append("Boboh2895+").toString();
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new UsersDBException("Could not load DB driver.", e);
        }
    }

    public Connection connect() throws UsersDBException, SQLException {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            Connection connection = null;
            DriverManager.setLoginTimeout(60);
            String url = new StringBuilder()
                    .append("jdbc:")
                    .append("postgresql")       // “mysql” / “db2” / “mssql” / “oracle” / ...
                    .append("://")
                    .append("localhost")
                    .append(":")
                    .append(5432)
                    .append("/")
                    .append("user_table")
                    .append("?user=")
                    .append("postgres")
                    .append("&password=")
                    .append("Boboh2895+").toString();
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new UsersDBException("Could not load DB driver.", e);
        }
    }

//    public static void setUpDB() throws UsersDBException, SQLException {
//        UsersDB tdb = new UsersDB();
//        try (Connection connection = tdb.connectToPostgreSQL()) {
//            Statement statement = connection.createStatement();
//            statement.execute("CREATE DATABASE user_test;");
//        }
//
//        // connect to newly created tests database and create tables.
//        try (Connection connection = tdb.connect()) {
//            StringBuilder builder = new StringBuilder();
//            builder.append("CREATE SEQUENCE user_ids;");
//            builder.append("CREATE TABLE user(id INT PRIMARY KEY DEFAULT NEXTVAL('user_ids'), " + "username VARCHAR(32), password VARCHAR(32);");
//
////            builder.append("CREATE SEQUENCE room_fair_ids;");
////            builder.append("CREATE TABLE room_fair(id INT PRIMARY KEY DEFAULT NEXTVAL('room_fair_ids'), " + "value DOUBLE PRECISION, season VARCHAR(32));");
////            builder.append("CREATE SEQUENCE accomodation_fair_relation_ids;");
////            builder.append("CREATE TABLE accomodation_fair_relation(id INT PRIMARY KEY DEFAULT NEXTVAL('accomodation_fair_relation_ids'), id_accomodation INT REFERENCES accomodation(id), id_room_fair INT REFERENCES room_fair(id));");
//
//            Statement statement = connection.createStatement();
////            statement = connection.createStatement();
//            statement.execute(builder.toString());
//        }
//    }
}
