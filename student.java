import java.util.*;

class student
{
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Total Number of grades : ");
		int totalgrade=s.nextInt();
		double grade;
		double sum=0.0;
		for(int i=0;i<totalgrade;i++)
		{
			System.out.println("Enter Grade "+(i+1)+" :");
			grade=s.nextDouble();
			sum=sum+grade;
		}
		
		double avg=sum/totalgrade;
			
		System.out.println("Average Is :"+avg);
		

	}
}