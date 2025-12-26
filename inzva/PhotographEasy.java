/*
Graduation day has arrived. It was a long but beautiful journey, and the students put in a great deal of effort.
Congratulations to everyone! Now it is time to have fun.

To immortalize this moment, Ekin picked up her camera. The students lined up side by side in front of the board. However, the camera has some limitations:

In terms of width, it can fit at most M students side by side in a single frame.
In terms of height, it cannot fit students who are taller than K centimeters into the frame.

Despite these limitations, Ekin does not lose her enthusiasm for taking photos and follows the method below.
If she can fit M people completely inside the frame, she takes a photo and says "Çekiyorum, gülümseyin" before each shot.

Compute the maximum number of times Ekin says "Çekiyorum, gülümseyin".

Note: The students cannot change their positions.
*/

import java.util.Scanner;

public class PhotographEasy {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] s1 = input.nextLine().split(" ");
        String[] s2 = input.nextLine().split(" ");

        int numStudents = Integer.parseInt(s1[0]);
        int personPerPhoto = Integer.parseInt(s1[1]);
        int heightLimit = Integer.parseInt(s1[2]);

        boolean[] heights = new boolean[numStudents];
        for (int i = 0; i < numStudents; i++) {
            int height = Integer.parseInt(s2[i]);
            heights[i] = height <= heightLimit;
        }
        int answer = 0;
        int index;
        int i = 0;

        while (i < numStudents) {
            index = findFirstM(i, numStudents, personPerPhoto, heights);
            if (index < 0) {
                System.out.println(answer);
                return;
            }
            else {
                i = index;
                while (i < numStudents && heights[i]) {
                    answer++;
                    i++;
                }
            }
            if (i == numStudents) {
                System.out.println(answer);
            }
        }

    }

    private static int findFirstM(int index, int numStudents, int personPerPhoto, boolean[] heights) {
        int count = 0;
        for (int i = index; i < numStudents; i++) {
            if (!heights[i]) {
                count = 0;
            }
            else {
                count++;
            }
            if (count == personPerPhoto) {
                return i;
            }
        }
        return -1;
    }
}
