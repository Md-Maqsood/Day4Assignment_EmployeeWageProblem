public class EmployeeWage{
	public static final int PART_TIME=1;
	public static final int FULL_TIME=2;

	private final String company;
	private final int ratePerHour;
	private final int numOfDays;
	private final int hoursPerMonth;
	private int totalEmpWage;
	
	public EmployeeWage(String company, int ratePerHour, int numOfDays, int hoursPerMonth) {
		super();
		this.company = company;
		this.ratePerHour = ratePerHour;
		this.numOfDays = numOfDays;
		this.hoursPerMonth = hoursPerMonth;
	}
	
	
	@Override
	public String toString() {
		return "Total Emp Wage for Company: "+company+" is: "+totalEmpWage;
	}


	public void computeEmpWage() {
		int totalEmpHrs=0;
		int workingDays=0;
		while(workingDays<numOfDays && totalEmpHrs<=hoursPerMonth){
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
			empWage=empHrs*ratePerHour;
			totalEmpWage+=empWage;
			totalEmpHrs+=empHrs;
			workingDays++;
			System.out.println("Day: "+workingDays+" Employee Hours: "+totalEmpHrs);
		}
	}
	public static void main(String[] args){
		EmployeeWage dmart=new EmployeeWage("Dmart", 20, 2, 10);
		EmployeeWage reliance=new EmployeeWage("Reliance", 10, 4, 20);
		dmart.computeEmpWage();
		System.out.println(dmart);
		reliance.computeEmpWage();
		System.out.println(reliance);
	}
}
