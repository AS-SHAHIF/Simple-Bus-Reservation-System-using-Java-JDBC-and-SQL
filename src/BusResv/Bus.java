package BusResv;

public class Bus {
    private int bus_no;
    private boolean ac;
    private int capacity;
    Bus(int bus_no,boolean ac,int capacity){
        this.bus_no=bus_no;
        this.ac=ac;
        this.capacity=capacity;
    }
    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int cap){
        capacity=cap;
    }
    public int getbusno(){
        return bus_no;
    }
    public boolean getAc(){
        return ac;
    }
    public void setAc(boolean val){
        ac=val;
    }
    public void displayInfo(){
        System.out.println("Bus Number:"+bus_no+","+"Ac:"+ac+","+"Total Capacity:"+capacity);
    }
}
