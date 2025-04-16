package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee {


	private String employeeId;

	private JoinedDate joinedDate;
	private int monthWorkingInYear;
	private EmployeeInfo employeeInfo;

	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;


	public Employee(String employeeId, JoinedDate joinedDate,employeeInfo employeeInfo) {
		this.employeeId = employeeId;
		this.joinedDate = joinedDate;
		this.employeeInfo = employeeInfo;



	}

	public void setMonthlySalary(int grade) {
		int baseSalary = switch (grade) {
			case 1 -> 3000000;
			case 2 -> 5000000;
			case 3 -> 7000000;
			default -> 0;
		}
		this.monthlySalary = employeeInfo.isForeigner() ? (int)(baseSalary * 1.5) : baseSalary;
	}

	public void setAnnualDeductible(int deductible) {
		this.annualDeductible = deductible;
	}

	public void setAdditionalIncome(int income) {
		this.otherMonthlyIncome = income;
	}

	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.employeeInfo.setSpouse(spouseName, spouseIdNumber);
	}

	public void addChild(String childName, String childIdNumber) {
		this.employeeInfo.addChild(childName, childIdNumber);
	}
	public int getAnnualIncomeTax() {
		int monthWorkingInYear = calculateMonthsWorkedInYear();
		TaxProfile taxProfile = createTaxProfile(monthWorkingInYear);
		return TaxFunction.calculateTax(taxProfile);
	}

	private int calculateMonthsWorkedInYear() {
		int currentYear = LocalDate.now().getYear();
		return (joinedDate.getYear() == currentYear)
				? LocalDate.now().getMonthValue() - joinedDate.getMonth()
				: 12;
	}

	private TaxProfile createTaxProfile(int monthWorkingInYear) {
		return new TaxProfile(
				monthlySalary,
				otherMonthlyIncome,
				monthWorkingInYear,
				annualDeductible,
				employeeInfo.hasSpouse(),
				employeeInfo.getNumberOfChildren()
		);
	}
}
