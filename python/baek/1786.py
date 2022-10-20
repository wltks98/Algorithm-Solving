def make_pi():
    pi = [0 for i in range(0, len(P))]

    j = 0
    for i in range(1, len(P)):
        while j > 0 and P[i] != P[j]:
            j = pi[j - 1] #왜 j=0이 아닌가 ->pi[j-1]을 통해 이전에 연속했던 위치로 가는거다 (p[i]와 p[j]가 같을때까지 계속 1씩 줄여가며)
                            #예시 AACAAA를 생각해보면 알 수 있다

        if (P[i] == P[j]):
            j += 1
            pi[i] = j
    return pi


def solution(pi):
    result = []
    count = 0

    j = 0
    for i in range(0, len(T)):

        while j > 0 and T[i] != P[j]:
            j = pi[j - 1]

        if T[i] == P[j]:
            if j == (len(P) - 1):
                result.append(i - len(P) + 2)
                count += 1
                j = pi[j]
            else:
                j += 1

    print(count)
    for element in result:
        print(element)


T = input()
P = input()
solution(make_pi())

