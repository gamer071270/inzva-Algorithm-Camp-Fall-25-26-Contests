/*
Emre and his friends recently embarked on a holiday, during which they incurred various expenses.
To keep track of their spending, they diligently collected all the receipts.
While at restaurants, one person graciously covered the entire bill, with the understanding that
others in the group would reimburse their respective shares upon their return from the holiday.

The group consists of n individuals, and they visited m different places.

Input Format
The first line specifies n, the number of people in their group.
The second line specifies m, the number of places they visited.
The next m lines each contains two integers, i and k. Here, i represents the person who paid the receipt, and k represents the amount of the respective receipt.

Output Format
For each person in the group, output a line with three variables: u, v, and y. Here,
u represents the person's identification number.
v represents either the amount they owe (debt) or the money they will receive.
y is a string indicating whether the person is a "debtor" or a "payee".
*/


import java.util.HashMap;
import java.util.Scanner;

/*
I could have just use an array. The index would be the person id.
 */

public class HolidayDebts {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<Integer, Long> map = new HashMap<>();

        int n = input.nextInt();
        int m = input.nextInt();
        input.nextLine();
        long sum = 0;

        for (int i = 0; i < m; i++) {
            String[] s = input.nextLine().split(" ");
            int id = Integer.parseInt(s[0]);
            long receipt = Long.parseLong(s[1]);
            sum += receipt;
            if (map.containsKey(id)) {
                long oldValue = map.get(id);
                long newValue = oldValue + receipt;
                map.replace(id, newValue);
            }
            else {
                map.put(id, receipt);
            }
        }
        long moneyPerPerson = sum / n;
        long moneyOwed;

        for (int i = 1; i <= n; i++) {
            if (map.containsKey(i)) {
                moneyOwed = map.get(i) - moneyPerPerson;
            }
            else {
                moneyOwed = (-1)*moneyPerPerson;
            }

            String result = i + " " + Math.abs(moneyOwed);

            if (moneyOwed > 0) {
                result += " payee";
            }
            else if (moneyOwed < 0){
                result += " debtor";
            }
            System.out.println(result);
        }


    }
}
