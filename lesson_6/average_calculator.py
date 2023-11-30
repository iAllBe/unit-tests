"""
Модуль класса AverageCalculator для сравнения средних значений списков.
"""


class AverageCalculator:
    """
    Класс предоставляет методы для сравнения средних значений двух списков.
    """

    def __init__(self, list1, list2):
        """
        Инициализирует экземпляр AverageCalculator двумя списками.
        """
        self.list1 = list1
        self.list2 = list2

    @staticmethod
    def calculate_average(lst):
        """
        Вычисляет среднее значение списка.
        """
        try:
            # Проверка типа элементов списка
            if not all(isinstance(x, (int, float)) for x in lst):
                raise TypeError("Список должен содержать только числа.")
            return sum(lst) / len(lst) if lst else 0
        except ZeroDivisionError:
            return 0

    def compare_averages(self):
        """
        Сравнивает средние значения двух списков и возвращает соответствующее
        сообщение.
        """
        if not all(
                isinstance(x, (int, float)) for x in self.list1 + self.list2):
            raise TypeError("Списки должны содержать только числа.")

        avg1 = self.calculate_average(self.list1)
        avg2 = self.calculate_average(self.list2)

        if avg1 == avg2:
            return "Средние значения равны"
        elif avg1 > avg2:
            return "Первый список имеет большее среднее значение"
        else:
            return "Второй список имеет большее среднее значение"

# calculator = AverageCalculator([1, 2, 3], [4, 5, 6])
# result = calculator.compare_averages()
# print(result)
