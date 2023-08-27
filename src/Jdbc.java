import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		try
		{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");  
			System.out.println("HEllo");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apmosys","root","system");  
			System.out.println("connection establish");
			Statement st=con.createStatement();
			System.out.print("Enter a name:");
			String NAME=sc.nextLine();
			System.out.print("Enter a ID:");
			int ID=sc.nextInt();
			System.out.print("Enter a price:");
			int price=sc.nextInt();
			System.out.print("Enter a quality:");
			String qty=sc.next();
			String m="insert into product values('"+ID+"','"+NAME+"','"+price+"','"+qty+"')";
			int c=st.executeUpdate(m);
			System.out.println("Successfully inserted");
			ResultSet rs=st.executeQuery("select * from product order by price");
			while(rs.next())
			{	
				System.out.println(rs.getInt("ID")+ "\t\t"+ rs.getString("NAME")+"\t\t"+ rs.getInt("price")+"\t\t"+ rs.getString("qty"));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}

}
