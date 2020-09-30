public class EmployeeWage{
	static final int FULL_TIME=1;
	public static void main(String[] args){
		int empcheck=(int)(Math.floor(Math.random()*10)%2);
		if (empcheck==FULL_TIME)
			System.out.println("Employee is present");
		else
			System.out.println("Employee is absent");
	}
}
