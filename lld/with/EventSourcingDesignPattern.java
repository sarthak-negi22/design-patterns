import java.util.ArrayList;
import java.util.List;

// Event
class AccountEvent {
    enum EventType { DEPOSIT, WITHDRAW }

    EventType type;
    int amount;

    public AccountEvent(EventType type, int amount) {
        this.type = type;
        this.amount = amount;
    }
}

// Bank Account with Event Sourcing
public class EventSourcingDesignPattern {
    private List<AccountEvent> events = new ArrayList<>();

    public void deposit(int amount) {
        events.add(new AccountEvent(AccountEvent.EventType.DEPOSIT, amount));
    }

    public void withdraw(int amount) {
        events.add(new AccountEvent(AccountEvent.EventType.WITHDRAW, amount));
    }

    public int getBalance() {
        int balance = 0;
        for (AccountEvent event : events) {
            if (event.type == AccountEvent.EventType.DEPOSIT) {
                balance += event.amount;
            } else if (event.type == AccountEvent.EventType.WITHDRAW) {
                balance -= event.amount;
            }
        }
        return balance;
    }

    public List<AccountEvent> getAllEvents() {
        return events;
    }

    public static void main(String[] args) {
        EventSourcingDesignPattern account = new EventSourcingDesignPattern();
        account.deposit(1000);
        account.withdraw(300);
        account.deposit(200);

        System.out.println("Current Balance: " + account.getBalance());
        System.out.println("Events:");
        for (AccountEvent e : account.getAllEvents()) {
            System.out.println(e.type + " -> " + e.amount);
        }
    }
}
