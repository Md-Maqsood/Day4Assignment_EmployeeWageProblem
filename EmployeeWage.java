public class EmployeeWage{
	static final int FULL_TIME=1;
	static final int WAGE_PER_HOUR=20;
	public static void main(String[] args){
		int empHrs=0;
		int empWage=0;
		int empcheck=(int)(Math.floor(Math.random()*10)%2);
		if (empcheck==FULL_TIME)
			empHrs=8;
		else
			empHrs=0;
		empWage=empHrs*WAGE_PER_HOUR;
		System.out.println("Employee Wage: "+empWage);
	}
}
