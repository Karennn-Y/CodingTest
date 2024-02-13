def solution(x, n):
    answer = []
    answer.append(x)
    num = x
    for i in range (1, n):
        num += x
        answer.append(num)
    return answer