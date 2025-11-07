import taxes.TaxSystem;

public class Main {

    public static void main(String[] args) {
        TaxSystem Ysndebit = new Ysndebit();
        TaxSystem Ysndebitminuscredit = new Ysndebitminuscredit();


        Company company1 = new Company("ООО 'Ромашка'", Ysndebit);
        System.out.println("Работа компании " + company1.getTitle() + " (УСН Доходы):");
        company1.shiftMoney(100_000);
        company1.shiftMoney(-30_000);
        company1.shiftMoney(50_000);
        company1.payTaxes();

        Company company2 = new Company("ИП 'Василек'", Ysndebitminuscredit);
        System.out.println("\nРабота компании " + company2.getTitle() + " (УСН Доходы минус расходы):");
        company2.shiftMoney(200_000);
        company2.shiftMoney(-150_000);
        company2.shiftMoney(-20_000);
        company2.payTaxes();


        System.out.println("\nДемонстрация смены системы налогообложения для ООО 'Ромашка':");
        company1.shiftMoney(80_000);
        company1.shiftMoney(-10_000);
        company1.setTaxSystem(Ysndebitminuscredit);
        company1.payTaxes();
    }
}