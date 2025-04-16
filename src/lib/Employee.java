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


		LocalDate date = LocalDate.now();

		if (date.getYear() == yearJoined) {
			monthWorkingInYear = date.getMonthValue() - monthJoined;
		}else {
			monthWorkingInYear = 12;
		}

		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber.equals(""), childIdNumbers.size());
	}
}
