import numpy as np

import numpy as np
import time

A = np.random.rand(24,13)
B = np.random.rand(13,55)
C = np.random.rand(55,72)
D = np.random.rand(72,19)

start = time.time()
E = np.dot(A,B)
F=np.dot(E,C)
G = np.dot(F,D)
end = time.time()
print(f"Time is {end - start: .10f}")

print("\n")
start = time.time()
E = np.dot(B,C)
F=np.dot(E,D)
G = np.dot(A,F)
end = time.time()
print(f"Time is {end - start: .10f}")

dicti = {"h":5,"a":5, "b":3, "k":4}
dicti = sorted(dicti.items(),key=lambda x:(-x[1],x[0]))[:3]
print(dicti)