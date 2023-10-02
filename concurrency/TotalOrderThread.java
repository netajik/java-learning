
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

class TotalOrderThread implements Runnable {

    private List<String> input;
    private Map<Integer, Integer> orderMap;

    public TotalOrderThread(List<String> input, Map<Integer, Integer> orderMap) {
        this.input = input;
        this.orderMap = orderMap;
    }

    public List<String> getInput() {
        return input;
    }

    public Map<Integer, Integer> getOrderMap() {
        return orderMap;
    }

    @Override
    public void run() {
        for (String order : input) {
            String[] orderDetails = order.split(",");
            int month = getMonth(orderDetails[1]);
            orderMap.put(month, orderMap.getOrDefault(month, 0) + 1);
        }
    }

    int getMonth(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = simpleDateFormat.parse(dateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(Calendar.MONTH) + 1;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        // System.out.println("Enter no of orders:");
        // int n = scanner.nextInt();
        List<String> orders = new ArrayList<>();

        // while (n-- > 0) {
        // orders.add(scanner.nextLine());
        // }

        String filePath = "C:\\Users\\kanch\\Documents\\practice\\java\\javacourse\\concurrency\\orders.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                orders.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        System.out.println("Enter No of threads:");

        int noOfThreads = scanner.nextInt();
        List<List<String>> subLists = new ArrayList<>();
        for (int i = 0; i < noOfThreads; i++) {
            subLists.add(new ArrayList<String>());
        }

        for (int i = 0; i < orders.size(); i++) {
            subLists.get(i % noOfThreads).add(orders.get(i));
        }

        Map<Integer, Integer> orderMap = new ConcurrentHashMap<>();

        for (List<String> sublist : subLists) {
            Thread thread = new Thread(new TotalOrderThread(sublist, orderMap));
            thread.start();
            thread.join();
        }

        String[] monthNames = new String[] {
                "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        };

        for (int i = 1; i <= 12; i++) {
            int count = orderMap.getOrDefault(i, 0);
            System.out.println(monthNames[i - 1] + " - " + count);
        }
    }

}
