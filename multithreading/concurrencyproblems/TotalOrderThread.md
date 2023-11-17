## Problem Statement: Shipping Purchase Order

The Shipping Company aims to analyze the number of purchase orders raised in a month over a year. Due to the large amount of historical purchase data, the tech team decides to implement report generation using multi-threading. Given order IDs and purchase dates, the goal is to print all the months with a minimum of 1 purchase within each month using threads.

**TotalOrderThread Class:**

Private Members:

- `List input`: List of purchase orders.
- `Map orderMap`: Map to store the count of orders per month.

Constructor:

- `TotalOrderThread(List<String> input, Map<Integer, Integer> orderMap)`: Initializes the TotalOrderThread with input and orderMap.

Method:

- `run()`: Overrides the run method to iterate through the purchase list, calculate the number of orders for each month, and store the value in orderMap.

**Main Class:**

Main method:

- Reads the number of orders.
- Reads the order details.
- Reads the number of threads.
- Divides the orders among threads.
- Creates threads to process orders.
- Waits for all threads to complete.
- Prints the count of orders for each month.

**Input Format:**

- The first line contains an integer `n`, the number of orders.
- The next `n` lines contain comma-separated strings corresponding to the order details.
- The following line contains an integer `t`, the number of threads to be executed.

**Output Format:**

- Prints the count of orders for each month that has at least one purchase.

**Note:** Ensure adherence to the object-oriented specifications and use the provided class names, attribute names, and method names.

Sample Input and Output are as follows:

```plaintext
Enter the number of orders: 24
Enter all the orders:
45512252,12/04/2015
45512522,05/06/2015
...
Enter number of threads to process the data: 2
Jan – 3
Feb – 4
Mar – 3
...
```
