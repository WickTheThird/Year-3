# def binary_digits(n):
#     if n == 0:
#         return '0'
#     bits = []
#     while n > 0:
#         bits.append(str(n % 2))
#         n //= 2
#     return ''.join(bits[::-1])

# def u_n(n):
#     binary_str = binary_digits(n)
#     count = 0
#     for i in range(len(binary_str) - 1):
#         if binary_str[i:i+2] == '11':
#             count += 1
#     return count


# def binary_expansion(n):
#     return bin(n)[2:]

# def count_block_11(binary):
#     count = 0
#     for i in range(len(binary)-1):
#         if binary[i:i+2] == '11':
#             count += 1
#     return count

# def r_n(n):
#     sequence = []
#     for i in range(n+1):
#         binary = binary_expansion(i)
#         block_count = count_block_11(binary)
#         if block_count % 2 == 0:
#             sequence.append(1)
#         else:
#             sequence.append(-1)
#     return sequence


# #> Generate the n sequence
# n = 45
# n_sequence = [i for i in range(n)]
# print(n_sequence, len(n_sequence))

# #> Generate the u_n terms
# u_values = 45
# u_n_sequence = [u_n(n) for n in range(u_values)]

# print(u_n_sequence, len(u_n_sequence))

# #> Geberate the r_n terms
# r_values = 44
# r_sequence = r_n(r_values)
# print(r_sequence, len(r_sequence))

# #> Generate the s(n) sequence
# def s(n, r_n):
#     final = []

#     sum = 0
#     for i in range(0, n):
#         sum += r_n[i]
        
#         final.append(sum)

#     return final

# print(s(45, r_sequence))

def count(n, x):
    ret = 0
    start = 0
    now = 0

    for hi in range(62, -1, -1):
        if (n >> hi) & 1:
            if now & 1:
                start = -start
                x = -x

            mid = start
            dff = 1 << ((hi + 1) >> 1)

            if hi & 1:
                d = x - start
                if d < dff:
                    ret += max(d, 0)
                elif d == dff:
                    ret += dff // 2
                start += dff
            else:
                mid += dff
                ret += max(0, dff - abs(mid - x))
                start = mid

            if now & 1:
                start = -start
                x = -x

            now += (n >> hi) % 4 == 3

    return ret

def pos(x, y):
    L, R = 1, 2 ** 62 - 1
    while L < R:
        m = (L + R) // 2
        if count(m, x) >= y:
            R = m
        else:
            L = m + 1
    return L

a, b = 1, 2
ans = 0

for i in range(2, 10):
    t = pos(b, a)
    # print(t, count(t, b), a)
    ans += t - 1
    c = b + a
    a, b = b, c

print(ans)
# print(count(1220847711, 54321), pos(54321, 12345) - 1)
