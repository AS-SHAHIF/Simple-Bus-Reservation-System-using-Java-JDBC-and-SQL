package BusResv;
import java.sql.*;
import java.util.Date;

public class BookindDao {
    public int getBookedCount(int bus_no,Date date) throws SQLException{
        String url="jdbc:mysql://localhost:3306/BResv";
        String username="root";
        String password="shahif";
        String query="Select count(passenger_name) from booking where bus_no=? and travel_date=?";
        Connection con = DriverManager.getConnection(url,username,password);
        PreparedStatement pst=con.prepareStatement(query);
        java.sql.Date sqldate=new java.sql.Date(date.getTime());
        pst.setInt(1,bus_no);
        pst.setDate(2,sqldate);
        ResultSet rs=pst.executeQuery();
        rs.next();
        return rs.getInt(1);

    }
    public void addBooking(Booking booking) throws SQLException{
        String url="jdbc:mysql://localhost:3306/BResv";
        String username="root";
        String password="shahif";
        String query="insert into booking values(?,?,?)";
        Connection con = DriverManager.getConnection(url,username,password);
        java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());
        PreparedStatement pst=con.prepareStatement(query);
        pst.setString(1,booking.passenger_name);
        pst.setInt(2,booking.bus_no);
        pst.setDate(3,sqldate);
        pst.executeUpdate();
    }
}
