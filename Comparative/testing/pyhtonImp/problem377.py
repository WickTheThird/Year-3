def find_combinations(target):
    memo = [[] for _ in range(target + 1)]
    memo[0] = [[]]

    for i in range(1, target + 1):
        for j in range(1, min(i + 1, 10)):
            if i - j >= 0:
                for prev_combination in memo[i - j]:
                    new_combination = prev_combination + [j]
                    memo[i].append(new_combination)

        # Remove combinations that exceed the target length
        memo[i] = [combination for combination in memo[i] if len(combination) <= target]

    return memo[target]


def main():
    target = int(input('Target: '))
    combinations = find_combinations(target)

    print(f"All possible combinations to make {target}:")

    total_sum = sum(int(''.join(map(str, combination))) for combination in combinations)

    print(total_sum)


if __name__ == "__main__":
    main()
