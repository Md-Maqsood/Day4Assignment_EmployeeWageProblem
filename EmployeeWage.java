public class EmployeeWage{
	public static final int PART_TIME=1;
	public static final int FULL_TIME=2;
	public static final int WAGE_PER_HOUR=20;
	public static final int WORKING_DAYS_IN_MONTH=20;
	public static final int MAX_WORKING_HOURS_IN_MONTH=100;
	public static void main(String[] args){
		int totalEmpWage=0;
		int totalEmpHrs=0;
		int workingDays=0;
		while(workingDays<WORKING_DAYS_IN_MONTH && totalEmpHrs<=MAX_WORKING_HOURS_IN_MONTH){
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
			totalEmpHrs+=empHrs;
			workingDays++;
			System.out.println("Day: "+workingDays+" Employee Hours: "+totalEmpHrs);
		}
		System.out.println("Total Employee Wage: "+totalEmpWage);
	}
}
