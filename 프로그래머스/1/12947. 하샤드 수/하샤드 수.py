def solution(x):
    sumNum = 0
    for i in str(x):
        sumNum += int(i)
    if x % sumNum == 0:
        return True
    return False