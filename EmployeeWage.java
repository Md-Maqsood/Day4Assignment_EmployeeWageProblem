public class EmployeeWage implements ComputeEmpWage{
	public static final int PART_TIME=1; 
	public static final int FULL_TIME=2;

	private int numOfCompany=0;
	private CompanyEmp[] companyEmpArray; 
	public EmployeeWage() {
		super();
		companyEmpArray = new CompanyEmp[5];
	}
	
	public void addCompanyEmp(String company, int ratePerHour, int numOfDays, int hoursPerMonth) {
		companyEmpArray[numOfCompany]=new CompanyEmp(company,ratePerHour,numOfDays,hoursPerMonth);
		numOfCompany++;
	}
	
	public void computeEmpWage() {
		for(int i=0;i<numOfCompany;i++) {
			companyEmpArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpArray[i]));
			System.out.println(companyEmpArray[i]);
		}
	}
	
	public int computeEmpWage(CompanyEmp companyEmp) {
		int totalEmpHrs=0;
		int workingDays=0;
		while(workingDays<companyEmp.numOfDays && totalEmpHrs<=companyEmp.hoursPerMonth){
			int empHrs=0;
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
			totalEmpHrs+=empHrs;
			workingDays++;
			System.out.println("Day: "+workingDays+" Employee Hours: "+totalEmpHrs);
		}
		return totalEmpHrs*companyEmp.ratePerHour;
	}
	
	public static void main(String[] args){
		
		EmployeeWage employeeWage=new EmployeeWage();
		employeeWage.addCompanyEmp("Dmart", 20, 2, 10);
		employeeWage.addCompanyEmp("Reliance", 10, 4, 20);
		employeeWage.computeEmpWage();
	}
}

interface ComputeEmpWage{
	public void addCompanyEmp(String company, int ratePerHour, int numOfDays, int hoursPerMonth);
	public void computeEmpWage();
}

class CompanyEmp{
	public final String company;
	public final int ratePerHour;
	public final int numOfDays;
	public final int hoursPerMonth;
	public int totalEmpWage; 
	
	public CompanyEmp(String company, int ratePerHour, int numOfDays, int hoursPerMonth) {
		super();
		this.company = company;
		this.ratePerHour = ratePerHour;
		this.numOfDays = numOfDays;
		this.hoursPerMonth = hoursPerMonth;
	}

	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage = totalEmpWage;
	}
	@Override
	public String toString() {
		return "Total Emp Wage for Company: "+company+" is: "+totalEmpWage;
	}
	
}

