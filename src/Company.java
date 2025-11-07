import taxes.TaxSystem;

public class Company {
    private String title;
    private int debit;
    private int credit;
    private TaxSystem taxSystem;

    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.debit = 0;
        this.credit = 0;
        this.taxSystem = taxSystem;
    }

    public String getTitle() {
        return title;
    }

    public void shiftMoney(int amount) {
        if (amount > 0) {
            debit += amount;
        } else if (amount < 0) {
            credit = +Math.abs(amount);
        }
    }
    public void payTaxes() {
        int taxAmount = taxSystem.calcTaxFor(debit, credit);
        System.out.println("Компания " + title + " уплатила налог в размере: " + taxAmount + " руб.");
        debit = 0;
        credit = 0;
    }

    public void setTaxSystem(TaxSystem newTaxSystem) {
        this.taxSystem = newTaxSystem;
        System.out.println(title + ": Система налогообложения изменена.");
    }

}

