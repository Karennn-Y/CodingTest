def solution(n):
    arr = str(n)
    answer = 0
    for i in arr:
        answer += int(i)
    return answer