def find_num_combinations(n):
    nums = [0] * (n + 1)
  
    nums[0] = nums[1] = 1
    nums[2] = 2
    nums[3] = 4

    for i in range(4, n + 1):
        nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3] + nums[i - 4]

    return nums[n]

print(find_num_combinations(10))
