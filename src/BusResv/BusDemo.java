package BusResv;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
public class BusDemo {
    public static void main(String args[]) throws SQLException{

        BusDao busDao=new BusDao();
        busDao.displayBusInfo();


        int option=1;
        Scanner sc=new Scanner(System.in);
        while(option==1){
            System.out.println("Enter 1 to Booking and 2 to Exit...");
            option=sc.nextInt();
            if(option==1) {
                try {
                    Booking booking=new Booking();
                    if(booking.isAvailable()){
                        BookindDao bookingdao = new BookindDao();
                        bookingdao.addBooking(booking);
                        System.out.println("Booking Confirmed...");
                    }else{
                        System.out.println("Currently No Seats Available for the Selected Bus,Try Another Bus");
                    }
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
