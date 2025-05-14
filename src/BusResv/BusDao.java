package BusResv;

import java.sql.*;

public class BusDao {
    public void displayBusInfo() throws SQLException{
        String url="jdbc:mysql://localhost:3306/BResv";
        String username="root";
        String password="shahif";
        String query="SELECT * FROM bus;";;
        Connection con = DriverManager.getConnection(url,username,password);
        Statement st=con.createStatement();
        try (ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("Bus No:" + rs.getInt(1));
                if (rs.getInt(2) == 0) {
                    System.out.println("Ac:no");
                } else {
                    System.out.println("Ac:yes");
                }
                System.out.println("Capacity:" + rs.getInt(3));
            }
        }
        System.out.println("--------------------------");

    }
    public int getCapacity(int id) throws SQLException{
        String url="jdbc:mysql://localhost:3306/BResv";
        String username="root";
        String password="shahif";
        String query="Select capacity from Bus where id="+id;
        Connection con = DriverManager.getConnection(url,username,password);
        Statement st=con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        return rs.getInt(1);
    }
}
