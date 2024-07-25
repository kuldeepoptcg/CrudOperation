package CurdOperation1;

import java.util.Scanner;

public class MainCurd {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		CurdOperation op=new CurdOperation();
		

		int k=1;
		first:
		while(k>=0){
			System.out.println("\n press 1 for insertion\n press 2 for Updation\n press 3 for delete\n Press for 4 Fetch Details of Bank\n Press for 0 for Exit  ");
			 k= sc.nextInt();
				switch(k) {
		case 1:
			op.Insert();
			break;
			
		case 2:
			op.Update();
			break;
		case 3:
			op.delete();
		break;
		case 4:
			op.select();
		break;
		case 0:
			System.out.println("-----------End Of Programme--------------");
		break first;
			default: 
				System.out.println("wrong Input");
				break;
							
			
		}
		
		
	}
	}
}