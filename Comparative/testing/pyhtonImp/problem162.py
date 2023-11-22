def calculate_hexadecimal_numbers():
    total_count = 0
    for n in range(1, 17):
        total_count += 15 * 16**(n - 1) + 41 * 14**(n - 1) - (43 * 15**(n - 1) + 13**n)
    return hex(total_count).replace("0x", "").upper()

result = calculate_hexadecimal_numbers()
print(result)
