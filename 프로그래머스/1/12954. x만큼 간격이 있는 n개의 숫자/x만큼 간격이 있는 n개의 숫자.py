def solution(x, n):
    answer = []
    for i in range (0, n):
        answer.append(i * x + x)
    return answer