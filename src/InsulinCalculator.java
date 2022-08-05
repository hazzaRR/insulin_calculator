import java.util.Scanner;

public class InsulinCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter your current Glucose (mmol): ");
        float currentBloodGlucose =  scanner.nextFloat();

        System.out.print("Enter your current glucose to carbs ratio as a decimal e.g 10 carbs = 1 unit so put 1.0: ");
        float carbToInsulinRatio =  scanner.nextFloat();

        System.out.print("Enter the amount of carbs you are about to eat (grams): ");
        float carbs =  scanner.nextFloat();

        // calculates your predicted glucose levels based on the given amount of carbs you are planning to eat and
        //your current blood glucose levels
        float predictedGlucose = ((carbs / 10) * 3) + currentBloodGlucose;

        float glucoseRangeGoal = predictedGlucose;

        boolean inRange = false;
        int units = 0;
        if (glucoseRangeGoal < 8.0 && glucoseRangeGoal > 5.0) {
            inRange = true;
        }

        //while your glucose levels are not in the range of 5-8 mmol, a unit of insulin is added to the dosage
        // and brings down the glucose levels by 3
        while (!inRange) {
            if (glucoseRangeGoal <= 8.0 && glucoseRangeGoal >= 5.0) {
                inRange = true;
                break;
            }
            units++;
            glucoseRangeGoal -= 3;
        }


        System.out.println("*******************************************************************");


        System.out.println("Predicted glucose levels after eating: " + predictedGlucose + "mmol");

        System.out.println("Recommended insulin unit dosage: " + (units * carbToInsulinRatio));
    }
}

