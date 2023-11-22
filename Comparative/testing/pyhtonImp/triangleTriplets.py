import math

def count_triangle_triples(n):
    count = 0
    for i in range(1, n):
        divisors_i = count_divisors(triangular_number(i))
        for j in range(i + 1, n):
            divisors_j = count_divisors(triangular_number(j))
            if divisors_j >= divisors_i:
                break
            for k in range(j + 1, n):
                divisors_k = count_divisors(triangular_number(k))
                if divisors_k < divisors_j:
                    count += 1
    return count

def triangular_number(n):
    return (n * (n + 1)) // 2

def count_divisors(num):
    count = 0
    sqrt_num = int(math.sqrt(num))
    for i in range(1, sqrt_num + 1):
        if num % i == 0:
            count += 2
    if sqrt_num * sqrt_num == num:
        count -= 1
    return count

# Example usage
n = 60000000
result = count_triangle_triples(n)
last_18_digits = result % (10**18)
print(last_18_digits)
