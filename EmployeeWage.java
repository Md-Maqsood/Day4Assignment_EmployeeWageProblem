import java.util.*;
public class EmployeeWage implements ComputeEmpWage{
	public static final int PART_TIME=1; 
	public static final int FULL_TIME=2;
	
	private ArrayList<CompanyEmp> companyEmpList;
	private Map<String,CompanyEmp> compToWageMap;
	public EmployeeWage() {
		super();
		companyEmpList = new ArrayList<CompanyEmp>();
		compToWageMap=new HashMap<String,CompanyEmp>();
	}
	
	public void addCompanyEmp(String company, int ratePerHour, int numOfDays, int hoursPerMonth) {
		CompanyEmp companyEmp=new CompanyEmp(company, ratePerHour, numOfDays, hoursPerMonth);
		companyEmpList.add(companyEmp);
		compToWageMap.put(company, companyEmp);
	}
	
	public void computeEmpWage() {
		for(int i=0;i<companyEmpList.size();i++) {
			companyEmpList.get(i).setTotalEmpWage(this.computeEmpWage(companyEmpList.get(i)));
			System.out.println(companyEmpList.get(i));
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
			companyEmp.dailyWage.put(workingDays,empHrs*companyEmp.ratePerHour);
			totalEmpHrs+=empHrs;
			workingDays++;
			System.out.println("Day: "+workingDays+" Employee Hours: "+totalEmpHrs);
		}
		return totalEmpHrs*companyEmp.ratePerHour;
	}
	
	@Override
	public int getTotalWage(String company) {
		return compToWageMap.get(company).totalEmpWage;
	}
	public static void main(String[] args){
		
		ComputeEmpWage employeeWage=new EmployeeWage();
		employeeWage.addCompanyEmp("Dmart", 20, 2, 10);
		employeeWage.addCompanyEmp("Reliance", 10, 4, 20);
		employeeWage.computeEmpWage();
		System.out.println("Total wage for Dmart Company: "+employeeWage.getTotalWage("Dmart"));
	}
}

interface ComputeEmpWage{
	public void addCompanyEmp(String company, int ratePerHour, int numOfDays, int hoursPerMonth);
	public void computeEmpWage();
	public int getTotalWage(String company);
}

class CompanyEmp{
	public final String company;
	public final int ratePerHour;
	public final int numOfDays;
	public final int hoursPerMonth;
	public int totalEmpWage; 
	public HashMap<Integer,Integer> dailyWage;
	public CompanyEmp(String company, int ratePerHour, int numOfDays, int hoursPerMonth) {
		super();
		this.company = company;
		this.ratePerHour = ratePerHour;
		this.numOfDays = numOfDays;
		this.hoursPerMonth = hoursPerMonth;
		this.dailyWage=new HashMap<Integer,Integer>();
	}

	public void setTotalEmpWage(int totalEmpWage) {
		this.totalEmpWage = totalEmpWage;
	}
	@Override
	public String toString() {
		return "Total Emp Wage for Company: "+company+" is: "+totalEmpWage;
	}
	
}

