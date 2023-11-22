
#! solution doesnt work but we shall come back to it later

def calculate_T(N):
    total_sum = 0

    max_power = int(N ** (1/3))

    for k in range(1, max_power + 1):
        exponent = int(N / (3 ** k))

        sum_denominator = (3 ** k) * (exponent * (exponent + 1)) // 2

        total_sum += sum_denominator

    return total_sum


result = calculate_T(100)
print(result)

# 10**14
