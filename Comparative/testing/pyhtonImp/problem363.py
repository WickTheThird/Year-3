memo = {}

def fn(n):
    if n in memo:
        return memo[n]
    
    if n < 1:
        return 0
    elif n == 3:
        return 3
    elif n == 2:
        return 1
    elif n == 1:
        return 1
    elif n % 2 == 0:
        memo[n] = fn(n // 2)
    elif n % 4 == 3:
        memo[n] = 3 * fn((1 - n) // 2) - 2 * fn((n - 3) // 4)
    else:
        memo[n] = 2 * fn((1 + n) // 2) - fn((1 - n) // 4)
    
    return memo[n]

def S(n):
    if n < 1:
        return 0
    elif n == 3:
        return 5
    elif n == 2:
        return 2
    elif n == 1:
        return 1
    elif n % 4 == 3:
        return -1 + 6 * S((1 - n) // 2) - 8 * S((n - 3) // 4)
    elif n % 4 == 2:
        return fn(n // 2) + S(n - 1)
    elif n % 4 == 1:
        return fn(n) + fn((1 - n) // 2) + S(n - 2)
    else:
        return fn(n // 4) + S(n - 1)

result = S(3**37)
print("Summation result:", result)
