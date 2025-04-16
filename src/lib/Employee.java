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

	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */

	public void setMonthlySalary(int grade) {
		int baseSalary = switch (grade) {
			case 1 -> 3000000;
			case 2 -> 5000000;
			case 3 -> 7000000;
			default -> 0;
		};
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

		//Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();

		if (date.getYear() == yearJoined) {
			monthWorkingInYear = date.getMonthValue() - monthJoined;
		}else {
			monthWorkingInYear = 12;
		}

		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber.equals(""), childIdNumbers.size());
	}
}
