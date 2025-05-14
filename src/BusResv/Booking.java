package BusResv;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Booking {
    String passenger_name;
    int bus_no;
    Date date;
    Booking() throws ParseException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Passenger Name:");
        passenger_name=sc.nextLine();
        System.out.println("Enter the Bus Number:");
        bus_no=sc.nextInt();
        System.out.println("Enter the Date (dd-mm-yyyy):");
        String dateInput=sc.next();
        SimpleDateFormat dateFormat=new SimpleDateFormat(("dd-MM-yyyy"));
        try {
            date=dateFormat.parse(dateInput);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isAvailable() throws SQLException {
        BusDao busDao=new BusDao();
        BookindDao bookingdao=new BookindDao();
        int capacity = busDao.getCapacity(bus_no);

        int booked = bookingdao.getBookedCount(bus_no,date);
        return booked<capacity;
    }

}

