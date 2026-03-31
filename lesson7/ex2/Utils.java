public class Utils {
    public static int calculateDigit(int number) {
        int firstDigit = number / 1000;
        int secondDigit = (number / 100) % 10;
        int thirdDigit = (number / 10) % 10;
        int fourthDigit = number % 10;

        int sum = firstDigit * 4 + secondDigit * 6 + thirdDigit * 8 + fourthDigit * 2;
        int digit = sum % 11;

        if (digit == 10) {
            return 0;
        }
        
        return digit;
    }
}
