import math

def solution(n):
    answer = 0
    num = math.sqrt(n)
    if int(num) != num:
        return -1
    return ((num + 1) ** 2)