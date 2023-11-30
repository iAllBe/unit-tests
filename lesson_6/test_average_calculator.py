import pytest
from average_calculator import AverageCalculator


@pytest.mark.parametrize("input_list", [
    (['a', 'b', 'c']),
    ([1, '2', 3]),
])
def test_invalid_input_raises_error(input_list):

    with pytest.raises(TypeError) as e:
        AverageCalculator.calculate_average(input_list)

    assert str(e.value) == "Список должен содержать только числа."


# Тесты для метода calculate_average
@pytest.mark.parametrize("input_list, expected_result", [
    ([1, 2, 3, 4, 5], 3),
    ([-1, -2, -3, -4, -5], -3),
    ([], 0),
    ([0, 0, 0], 0),
])
def test_calculate_average(input_list, expected_result):
    result = AverageCalculator.calculate_average(input_list)

    assert result == expected_result


# Тесты для метода compare_averages с результатом
# "Средние значения равны"
@pytest.mark.parametrize("list1, list2", [
    ([1, 2, 3], [3, 2, 1]),
    ([], []),
])
def test_compare_averages_lists_equal(list1, list2):
    calculate = AverageCalculator(list1, list2)
    result = calculate.compare_averages()

    assert result == "Средние значения равны"


# Тесты для метода compare_averages с результатом
# "Второй список имеет большее среднее значение"
@pytest.mark.parametrize("list1, list2", [
    ([0, 0, 0], [1, 2, 3]),
    ([], [1]),
])
def test_compare_averages_second_greater(list1, list2):
    calculate = AverageCalculator(list1, list2)
    result = calculate.compare_averages()

    assert result == "Второй список имеет большее среднее значение"


# Тесты для метода compare_averages с результатом
# "Первый список имеет большее среднее значение"
@pytest.mark.parametrize("list1, list2",
                         [
                             ([1, 2, 3], [0, 0, 0]),
                             ([-1, -2, -3], [-4, -5, -6]),
                             ([1], []), ])
def test_compare_averages_with_first_greater(list1, list2):
    calculate = AverageCalculator(list1, list2)
    result = calculate.compare_averages()

    assert result == "Первый список имеет большее среднее значение"
