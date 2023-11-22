from math import isqrt

def prime_factors_count(n):
    factors = {}
    for p in range(2, n + 1):
        while n % p == 0:
            n //= p
            factors[p] = factors.get(p, 0) + 1
        if n == 1:
            break
    return factors

def count_solutions(target_solutions):
    n = 2
    while True:
        factors = prime_factors_count(n)
        count = 1
        for p in factors.values():
            count *= 2 * p + 1
        count = (count + 1) // 2
        
        if count > target_solutions:
            return n
        n += 1

target_solutions = 2
least_n = count_solutions(target_solutions)
print(least_n)
