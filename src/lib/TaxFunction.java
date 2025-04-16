	package lib;

	public class TaxFunction {
		private static final int PERSONAL_ALLOWANCE = 54_000_000;
		private static final int MARRIED_ALLOWANCE = 4_500_000;
		private static final int CHILD_ALLOWANCE = 1_500_000;
		private static final double TAX_RATE = 0.05;
		private TaxProfile profileofile;
		public static int calculateTax(TaxProfile profile) {

			int totalIncome = (profile.getMonthlySalary() + profile.getOtherMonthlyIncome()) * profile.getNumberOfMonthWorking();
			int ptkp = calculatePTKP(profile.isMarried(), profile.getNumberOfChildren());
			int taxableIncome = totalIncome - profile.getDeductible() - ptkp;

			int tax = (int) Math.round(TAX_RATE * taxableIncome);
			return Math.max(tax, 0);
		}

	}
