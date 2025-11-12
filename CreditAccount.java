
class CreditAccount extends Account {
    private final long creditLimit;

    public CreditAccount(long initialBalance, long creditLimit) {
        super(initialBalance);
        this.creditLimit = creditLimit;
        if (balance > 0) {
            balance = 0;
        }
    }

    @Override
    public boolean add(long amount) {
        if (amount <= 0) {
            return false;
        }
        if (balance + amount > 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    @Override
    public boolean pay(long amount) {
        if (amount <= 0) {
            return false;
        }
        if (balance - amount < -creditLimit) {
            return false;
        }
        balance -= amount;
        return true;
    }
}