public class EmployeeWage{
	static final int PART_TIME=1;
	static final int FULL_TIME=2;
	static final int WAGE_PER_HOUR=20;
	static final int WORKING_DAYS_IN_MONTH=20;
	public static void main(String[] args){
		int totalEmpWage=0;
		for(int days=1;days<=WORKING_DAYS_IN_MONTH;days++){
			int empHrs=0;
			int empWage=0;
			int empcheck=(int)(Math.floor(Math.random()*10)%3);
			switch(empcheck){
				case FULL_TIME:
					empHrs=8;
					break;
				case PART_TIME:
					empHrs=4;
					break;
				default:
					empHrs=0;
			}
			empWage=empHrs*WAGE_PER_HOUR;
			totalEmpWage+=empWage;
			System.out.println("Employee Wage: "+empWage);
		}
		System.out.println("Tolal Employee Wage: "+totalEmpWage);
	}
}
	

