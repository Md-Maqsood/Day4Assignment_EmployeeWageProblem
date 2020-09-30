public class EmployeeWage{
	public static final int PART_TIME=1;
	public static final int FULL_TIME=2;
	public static final int WAGE_PER_HOUR=20;
	public static final int WORKING_DAYS_IN_MONTH=20;
	public static final int MAX_WORKING_HOURS_IN_MONTH=100;
	
	public static int calcEmpWageForCompany(String company, int empRate,int numOfdays, int maxHrs) {
		int totalEmpWage=0;
		int totalEmpHrs=0;
		int workingDays=0;
		while(workingDays<numOfdays && totalEmpHrs<=maxHrs){
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
			empWage=empHrs*empRate;
			totalEmpWage+=empWage;
			totalEmpHrs+=empHrs;
			workingDays++;
			System.out.println("Day: "+workingDays+" Employee Hours: "+totalEmpHrs);
		}
		System.out.println("Total Employee Wage for company "+company+"is "+totalEmpWage);
		return totalEmpWage;
	}
	public static void main(String[] args){
		calcEmpWageForCompany("Dmart",20,2,10);
		calcEmpWageForCompany("Reliance",10,4,20);
	}
}
