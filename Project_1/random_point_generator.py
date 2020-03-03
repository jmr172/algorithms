from random import randint, sample, seed
import sys

num_points = int(sys.argv[1])
max_value = 100000

with open("inputs/input1.txt", 'w') as out_file:
    seed()
    x = sample(range(max_value), num_points)
    x.sort()
    y = sample(range(max_value), num_points)
    for i in range(num_points):
        # print(str(x[i]) + "," + str(y[i]))
        out_file.write(str(x[i]) + "," + str(y[i]) + "\n")
print("Done.")
