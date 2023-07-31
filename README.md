# VendingMachine

<img src="https://github.com/anisha-04/IOS-Development/blob/main/GIF/Vending.PNG" />


# Vending Machine

## Description

The Vending Machine is a class implementation that models a simple vending machine with the following functionalities:

- *Constructor*: The class provides two constructors, one with a parameter for the serial number only and another with parameters for the serial number and location. The constructor initializes the vending machine with the given serial number and either sets the location to "UNKNOWN" or the provided location.

- *toString*: This method returns a string representation of the vending machine, including its serial number, location, and current stock information for the available items.

- *buyItem*: This method allows customers to buy items from the vending machine. There are two overloaded versions of this method. The first version takes an item ID as input and adds one unit of that item to the customer's order if there is sufficient stock. The second version takes both the item ID and the quantity of items the customer wants to buy. If there is enough stock, it adds the specified quantity to the order.

- *pay*: After selecting the items and placing the order, customers can pay for their selection. This method checks if the payment is sufficient to cover the total order cost, including a 10% tax. If the payment is enough, it calculates the return amount, clears the current order, and adds the sold items to the soldCounts array. If the payment is insufficient, it returns the money and prints an error message.

- *displayReceipt*: This method shows the current order with the items ordered, the cost, a subtotal, and the total amount, including tax.

- *returnItem*: Customers can return items they previously ordered. This method takes the item ID and the quantity to return as parameters. If the customer attempts to return more items than were in the order, it sets the order quantity for that item to zero and only returns how many were in the order.

- *equals*: This method compares the stock quantities of the four items in two vending machines. If the stock quantities are the same, it returns true; otherwise, it returns false.

- *resetItems*: This method sets the quantity of each stock item to exactly the number passed in. It is used when a machine administrator resets the contents of a machine.

- *addItems*: This method allows a system administrator to add items to the vending machine. It takes the number of items to add for each stock item as input.

- *getSerialNumber*: This method returns the serial number of the vending machine.

- *setSerialNumber*: This method allows the serial number of the vending machine to be set to the provided value.

- *getLocation*: This method returns the location of the vending machine.

- *setLocation*: This method allows the location of the vending machine to be set to the provided value.

- *orderTotal*: This method returns the cost of the total order, including 10% tax.

- *toDollars*: This method returns a string showing the dollar amount (to two decimal places) of the double value passed in.

## Example Usage

java
VendingMachine machine1 = new VendingMachine(100);
VendingMachine machine2 = new VendingMachine(200, "Library");
System.out.println("===== Welcome to the CSUMB Vending Machine =====");
System.out.println(machine1);
System.out.println("");
System.out.println(machine2);
System.out.println("\n=== Compare Two Machines ===");
System.out.println(machine1.equals(machine2));
machine1.setLocation("BIT104");
machine1.setSerialNumber(50);
machine1.setSerialNumber(100);
System.out.println("\n=== Machine Reset ===");
// for machine1() we assume that a machine administrator
// resets the contents of a machine
machine1.resetItems(4, 5, 0, 6);
machine1.addItems(1, 2, 3, 4);
// A system admin can add items to the machine
System.out.println(machine1);
System.out.println();
System.out.println("\n=== Buy an Item ===");
machine1.buyItem(2);
System.out.println("\n=== Buy another Item ===");
if (machine1.buyItem(1, 4) == false) {
    System.exit(1);
}
System.out.println("\n=== Return Two Items ===");
machine1.returnItem(1, 2);
machine1.returnItem(2, 3);
System.out.println("\n=== Buy another Item ===");
machine1.buyItem(3, 5);
machine1.buyItem(3, 2);
System.out.println("\n=== Pay for items selected. ===");
if (machine1.pay(2.0)) {
    System.out.println("\n=== Valid payment. ===");
} else {
    System.out.println("\n=== Invalid payment. Try one more time. ===");
    machine1.pay(7.0);
}
machine1.addItems(5, 5, 5, 5);
System.out.println("\n=== Machine Status ===");
System.out.println(machine1);
System.out.println("\n===== Thank you! =====");


The output of the example run will be similar to the provided example run in the description. The vending machine allows users to select items, display the order and its cost, and make payments for their selection. Administrators can reset and add items to the machine.
