// abstract class for parking spots
abstract class ParkingSpot {
    private int id;
    private boolean isFree;

    public ParkingSpot(int id) {
        this.id = id;
        this.isFree = true;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean isFree) {
        this.isFree = isFree;
    }

    public int getId() {
        return id;
    }
}

// concrete parking spots
class LargeSpot extends ParkingSpot {
    public LargeSpot(int id) {
        super(id);
    }
}

class MotorcycleSpot extends ParkingSpot {
    public MotorcycleSpot(int id) {
        super(id);
    }
}

class CompactSpot extends ParkingSpot {
    public CompactSpot(int id) {
        super(id);
    }
}

// abstract class for vehicle
abstract class Vehicle {
    private String licenseNumber;

    public Vehicle(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public abstract void assignParkingTicket(ParkingTicket ticket);
}

// concrete vehicles
class Car extends Vehicle {
    public Car(String licenseNumber) {
        super(licenseNumber);
    }

    @Override
    public void assignParkingTicket(ParkingTicket ticket) {
        System.out.println("Assigning ticket to car:"+getLicenseNumber());
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String licenseNumber) {
        super(licenseNumber);
    }

    @Override
    public void assignParkingTicket(ParkingTicket ticket) {
        System.out.println("Assigning ticket to motorcycle:"+getLicenseNumber());
    }
}

// abstract class for payment methods
abstract class Payment {
    protected double amount;
    protected String status;

    public Payment(double amount) {
        this.amount = amount;
        this.status = "Pending...";
    }

    public abstract void initiateTransaction();
}

// concrete classes for payments
class CashPayment extends Payment {
    public CashPayment(double amount) {
        super(amount);
    }

    @Override
    public void initiateTransaction() {
        System.out.println("Processing cash payment of Rs."+amount);
        this.status = "Completed!";
    }
}

class CreditCardPayment extends Payment {
    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public void initiateTransaction() {
        System.out.println("Processing credit card payment of Rs."+amount);
        this.status = "Completed!";
    }
}

class ParkingTicket {
    private int ticketNumber;
    private long timeStamp;
    private double amount;
    private Payment payment;

    public ParkingTicket(int ticketNumber) {
        this.ticketNumber = ticketNumber;
        this.timeStamp = System.currentTimeMillis();
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }


    public Payment getPayment() {
        return payment;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }
}

class ParkingLot {
    private String name;
    private String address;
    private boolean isFull;

    public ParkingLot(String name, String address) {
        this.name = name;
        this.address = address;
        this.isFull = false;
    }

    public boolean isFull() {
        return isFull;
    }

    public ParkingTicket getParkingTicket(Vehicle vehicle) {

        if(isFull) {
            System.out.println("All parking spots are currently occucpied!");
            return null;
        } else {
            System.out.println("Generating ticket for vehicle:"+vehicle.getLicenseNumber());
            return new ParkingTicket((int) (Math.random() * 1000));
        }
    }
}

public class CarParkingLotSystem {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("Central Parking", "125 Main Street");

        Vehicle car = new Car("DL567 7612");
        ParkingTicket ticket = parkingLot.getParkingTicket(car);
        car.assignParkingTicket(ticket);

        Payment payment = new CreditCardPayment(45.5);
        payment.initiateTransaction();
        ticket.setPayment(payment);

        System.out.println("Parking ticket processed:"+ticket.getTicketNumber());
        System.out.println("Payment Status:"+payment.status);
    }    
}
