package Calculator;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    public static void main(String[] args) {

//    Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и
//    проверить его, используя AssertJ

        assertThatThrownBy(() ->
                Calculator.calculateDiscount(-1000, 50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Сумма покупки не должна быть отрицательной !!!");

        assertThatThrownBy(() ->
                Calculator.calculateDiscount(1000, -10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100% !!!");

        assertThatThrownBy(() ->
                Calculator.calculateDiscount(1000, 101))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100% !!!");



        assertThat(Calculator.calculateDiscount(1000, 50)).isEqualTo(500);
        assertThat(Calculator.calculateDiscount(1000, 100)).isEqualTo(0);
        assertThat(Calculator.calculateDiscount(1000, 10)).isEqualTo(900);
        assertThat(Calculator.calculateDiscount(1000, 0)).isEqualTo(1000);
    }
}