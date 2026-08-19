package vn.edu.phenikaa;

public class Main {

    public static void main(String[] args) {
        RewardPointCalculator calculator = new RewardPointCalculator();

        int premiumPoints = calculator.calculate(2, true);
        int regularPoints = calculator.calculate(1, false);

        System.out.println("Khách Premium, 2 lần mua: " + premiumPoints + " điểm");
        System.out.println("Khách thường, 1 lần mua: " + regularPoints + " điểm");
    }
}

class RewardPointCalculator {

    public int calculate(int purchases, boolean premiumMember) {
        if (purchases < 0 || purchases > 2) {
            throw new IllegalArgumentException("Số lần mua phải nằm trong khoảng từ 0 đến 2");
        }

        int points = 0;
        for (int i = 0; i < purchases; i++) {
            points += 10;
        }

        if (premiumMember) {
            points += 5;
        } else {
            points += 1;
        }

        return points;
    }
}

