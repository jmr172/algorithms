from random import randint, sample, seed
import sys

num_points = int(sys.argv[1])
max_value = 50000

with open(sys.argv[2], 'w') as out_file:
    seed()
    x = sample(range(max_value), num_points)
    # x.sort()
    # y = x[::-1]
    for i in range(num_points):
        out_file.write(str(x[i]) + "\n")
print("Done.")
