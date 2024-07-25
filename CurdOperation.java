package CurdOperation1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class CurdOperation  {
	Scanner sc=new Scanner(System.in);
	static Connection CreatConnection()throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/opkuldeep","root","Opk@1984");
		System.out.println("Connection Successfully Created");
		
		return conn;
		
	}
//	insertion
	public void Insert()throws Exception{
		
		System.out.println("Plz Enter CustomerName For Insertion Data");
		String Customername=sc.nextLine();
		System.out.println("Plz enter Atm Number");
		String Atmnum=sc.nextLine();
		System.out.println("Plz enter Mobile Number");
		String Mobilenum=sc.nextLine();
		Connection db= CreatConnection();
		PreparedStatement pst=db.prepareStatement("insert into Bank (Customername, Atmnum, Mobilenum) values( ?, ?, ?)");
		pst.setString(1,Customername);
		pst.setString(2, Atmnum);
		pst.setString(3, Mobilenum);
		int i=pst.executeUpdate();
		if(i>0) {
			System.out.println("Successfully insertion");
		}else {
			System.out.println("insertion Failed");
		}
		
	}
		public void Update()throws Exception{
			
			System.out.println("Plz Enter CustomerName For Updation");
			String Customername=sc.nextLine();			
			System.out.println("Plz enter CustomerID");
			int CustomerId=sc.nextInt();
			Connection db= CreatConnection();
			PreparedStatement pst=db.prepareStatement("update Bank set Customername =? where CustomerId =?");
			pst.setString(1, Customername);
			pst.setInt(2,CustomerId);

			int k=pst.executeUpdate();
			if(k>0) {
				System.out.println("Successfully Updation");
			}else {
				System.out.println("Updation Failed");
			}
	}
	
public void delete()throws Exception{
			
			System.out.println("Plz Enter CustomerId For Delete Data");
			int CustomerId=sc.nextInt();
			
			Connection db= CreatConnection();
			PreparedStatement pst=db.prepareStatement("delete from Bank where CustomerId =? ");
			pst.setInt(1, CustomerId);

			int k=pst.executeUpdate();
			if(k>0) {
				System.out.println("Successfully Deletation Data of CustomerId  "+CustomerId);
			}else {
				System.out.println("Deletation Failed");
			}
	
}
public void select()throws Exception{
	
	System.out.println("Fetch Details of Bank");
	Connection db= CreatConnection();
	PreparedStatement pst=db.prepareStatement("select*from Bank ");
	ResultSet rs=pst.executeQuery();
	while(rs.next()) {

	System.out.println(rs.getInt(1));
	System.out.println(rs.getString(2));
	
	}

	}
}


