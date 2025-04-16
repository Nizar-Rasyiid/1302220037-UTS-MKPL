package lib;

public class TaxProfile {
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int numberOfMonthWorking;
    private int deductible;
    private boolean isMarried;
    private int numberOfChildren;

    public TaxProfile(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
        this.monthlySalary = monthlySalary;
        this.otherMonthlyIncome = otherMonthlyIncome;
        this.numberOfMonthWorking = Math.min(numberOfMonthWorking, 12);
        this.deductible = deductible;
        this.isMarried = isMarried;
        this.numberOfChildren = Math.min(numberOfChildren, 3);
    }

    // Getters
    public int getMonthlySalary() { return monthlySalary; }
    public int getOtherMonthlyIncome() { return otherMonthlyIncome; }
    public int getNumberOfMonthWorking() { return numberOfMonthWorking; }
    public int getDeductible() { return deductible; }
    public boolean isMarried() { return isMarried; }
    public int getNumberOfChildren() { return numberOfChildren; }
}
