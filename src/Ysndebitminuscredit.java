import taxes.TaxSystem;

public class Ysndebitminuscredit extends TaxSystem {
    @Override
    public int calcTaxFor(int debit, int credit){
        int taxAmount = (int) ((debit - credit) * 0.15);
        return Math.max(0, taxAmount);
    }
}
