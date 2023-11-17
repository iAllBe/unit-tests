package Calculator;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("Дважды Два = " + calculate(2, 2, '*'));
    }

    public static int calculate(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Деление на ноль невозможно!!!");
                }
            default:
                throw new IllegalArgumentException("Неизвестный оператор: " + operator + " !!!");
        }

        return result;
    }

//    Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и
//    проверить его, используя AssertJ

    public static double calculateDiscount(double purchaseAmount, int discountAmount) {

        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("Сумма покупки не должна быть отрицательной !!!");
        }

        if (discountAmount < 0 || discountAmount > 100) {
            throw new IllegalArgumentException("Скидка должна быть в диапазоне от 0 до 100% !!!");
        }

        return purchaseAmount - (purchaseAmount * discountAmount) / 100;
    }
}
