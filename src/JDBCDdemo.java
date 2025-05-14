import java.sql.*;

public class JDBCDdemo {
    public static void main(String args[]) throws SQLException {
//        readValues();
//        insertVar();
//        insertUsingPst();
//        deleteRow();
//        updateValues();
//        sp1();
//        sp2();
//        sp3();
//        commitdemo();
//        batchDemo();
    }
    //read values
    public static void readValues() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/Testing";
        String username = "root";
        String password = "shahif";
        String query = "select*from employee";
        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            System.out.println("RRN:" + rs.getInt(1));
            System.out.println("NAME:" + rs.getString(2));
            System.out.println("SALARY:" + rs.getInt(3));
            System.out.println("-------------");
        }
    }
    //using Variables to insert values
    public static void insertVar() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/Testing";
        String username = "root";
        String password = "shahif";
        int id=10;
        String name="Anitha";
        int salary=33000;
        //insert into employee values(09,'Anbu',45000);
        String query = "insert into employee values("+id+",'"+name+"',"+salary+");";
        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();
        int row = st.executeUpdate(query);
        System.out.println("Number of Rows Affected:"+row);
    }
    //Using Prepared Statement to insert Values
    public static void insertUsingPst() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/Testing";
        String username = "root";
        String password = "shahif";
        int id=02;
        String name="Gani";
        int salary=34000;
        String query="insert into employee values(?,?,?);";
        Connection con = DriverManager.getConnection(url, username, password);
        PreparedStatement pt=con.prepareStatement(query);
        pt.setInt(1,id);
        pt.setString(2,name);
        pt.setInt(3,salary);
        int row=pt.executeUpdate();
        System.out.println("Number of Rows Affected:"+row);
    }
    //delete Row
    public static void deleteRow() throws SQLException{
        String url="jdbc:mysql://localhost:3306/Testing";
        String username="root";
        String password="shahif";
        int id=10;
        String query="delete from employee where emp_id="+id;
        Connection con=DriverManager.getConnection(url,username,password);
        Statement st=con.createStatement();
        int row=st.executeUpdate(query);
        System.out.println("Rows Affected:"+row);
    }
    //Update Values
    public static void updateValues() throws SQLException{
        String url="jdbc:mysql://localhost:3306/Testing";
        String username="root";
        String password="shahif";
        int id=7;
        String query="UPDATE employee SET salary=400000 where emp_id="+id;
        Connection con=DriverManager.getConnection(url,username,password);
        Statement st=con.createStatement();
        int row=st.executeUpdate(query);
        System.out.println("Rows Affected:"+row);
    }
    //Stored Procedure Exaxmple -1 without Parameter
    public static void sp1() throws SQLException{
        String url="jdbc:mysql://localhost:3306/Testing";
        String username="root";
        String password="shahif";
        Connection con=DriverManager.getConnection(url,username,password);
        CallableStatement cst=con.prepareCall("{call GetEmp()}");
        ResultSet rs=cst.executeQuery();
        while (rs.next()) {
            System.out.println("RRN:" + rs.getInt(1));
            System.out.println("NAME:" + rs.getString(2));
            System.out.println("SALARY:" + rs.getInt(3));
            System.out.println("-------------");
        }
    }
    //Stored Procedure Exaxmple -2 with IN Parameter
    public static void sp2() throws SQLException{
        String url="jdbc:mysql://localhost:3306/Testing";
        String username="root";
        String password="shahif";
        int id=7;
        Connection con=DriverManager.getConnection(url,username,password);
        CallableStatement cst=con.prepareCall("{call gtEp(?)}");
        cst.setInt(1,id);
        ResultSet rs=cst.executeQuery();
        while (rs.next()) {
            System.out.println("RRN:" + rs.getInt(1));
            System.out.println("NAME:" + rs.getString(2));
            System.out.println("SALARY:" + rs.getInt(3));
            System.out.println("-------------");
        }
    }
    //Stored Procedure Exaxmple -3 with IN and OUT Parameter
    public static void sp3() throws SQLException{
        String url="jdbc:mysql://localhost:3306/Testing";
        String username="root";
        String password="shahif";
        int id=7;
        Connection con=DriverManager.getConnection(url,username,password);
        CallableStatement cst=con.prepareCall("{call GetEmpNameByid(?,?)}");
        cst.setInt(1,id);
        cst.registerOutParameter(2,Types.VARCHAR);
        cst.execute();
        System.out.println(cst.getString(2));
    }
    //COMMIT / AUTOCOMMIT
    public static void commitdemo() throws SQLException{
        String url="jdbc:mysql://localhost:3306/Testing";
        String username="root";
        String password="shahif";
        String query1="UPDATE employee SET salary=600000 where emp_id=2";
        String query2="UPDATE employee SET salary=600000 where emp_id=3";
        Connection con=DriverManager.getConnection(url,username,password);
        con.setAutoCommit(false);
        Statement st=con.createStatement();
        int row1=st.executeUpdate(query1);
        System.out.println("Row Affected:"+row1);
        int row2=st.executeUpdate(query2);
        System.out.println("Row Affected:"+row2);
        if(row1>0 && row2>0)
            con.commit();
        con.close();
    }
    //BATCH PROCESSING
    public static void batchDemo() throws SQLException{
        String url="jdbc:mysql://localhost:3306/Testing";
        String username="root";
        String password="shahif";
        String query1="UPDATE employee SET salary=600000 where emp_id=2";
        String query2="UPDATE employee SET salary=600000 where emp_id=3";
        String query3="UPDATE employee SET salary=600000 where emp_id=5";
        String query4="UPDATE employee SET salary=600000 where emp_id=7";
        Connection con=DriverManager.getConnection(url,username,password);
        con.setAutoCommit(false);
        Statement st=con.createStatement();
        st.addBatch(query1);
        st.addBatch(query2);
        st.addBatch(query3);
        st.addBatch(query4);
        int result[]=st.executeBatch();
        for(int i:result){
            if(i>0)
                continue;
            else
                con.rollback();
        }
        con.close();
    }
}
