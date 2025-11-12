class SimpleAccount extends Account {

    public SimpleAccount(long initialBalance) {
        super(initialBalance);
    }

    @Override
    public boolean add(long amount) {
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    @Override
    public boolean pay(long amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }
}
