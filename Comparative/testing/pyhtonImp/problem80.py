from decimal import Decimal, getcontext
from math import sqrt

class SquareRootCalculator:
    @staticmethod
    def main():
        calculator = SquareRootCalculator()
        print(calculator.calculate_total_sum())

    def calculate_total_sum(self):
        total_sum = 0
        for a in range(1, 101):
            sqrt_val = sqrt(a)
            if sqrt_val != int(sqrt_val):
                getcontext().prec = 102
                sqrt_decimal = Decimal(a).sqrt()
                first_100_digits = str(sqrt_decimal).replace('.', '')[:100]
                digital_sum = sum(int(digit) for digit in first_100_digits)
                total_sum += digital_sum
        return total_sum

if __name__ == "__main__":
    SquareRootCalculator().main()
