def solution(s):
    word = s.lower()
    pCnt = word.count('p')
    yCnt = word.count('y')
    return pCnt == yCnt