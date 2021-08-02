package database;

import java.sql.*;

public class dbHandler extends Config{
    Connection dbConn;

    public Connection getDbConn() throws SQLException, ClassNotFoundException {
        //jdbc:mysql://localhost/3306/dbName;
        String connString = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
         dbConn = DriverManager.getConnection(connString,dbusername,dbpassword);

        return dbConn;
    }
    public dbHandler() throws SQLException, ClassNotFoundException {
        dbConn = getDbConn();
        if(dbConn==null){
            System.exit(1);
        }
    }

    public boolean isDBConnected() throws SQLException {
        return !dbConn.isClosed();
    }

    public boolean loginNow(String tblName, String user,String pass) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = null;
        PreparedStatement prepareStatement = null;

        String query = "SELECT * FROM "+tblName+" WHERE userName = ? and password = ? ";
                //+ Const.USER_TABLE+" WHERE "+ Const.USER_USERNAME+"=?"+user+" AND "+Const.USER_PASSWORD +" =? ";

        prepareStatement = getDbConn().prepareStatement(query);

        prepareStatement.setString(1,user);
        prepareStatement.setString(2,pass);

        resultSet = prepareStatement.executeQuery();

        if(resultSet.next()){
            return true;
        }
        else
            return false;

    }



}
