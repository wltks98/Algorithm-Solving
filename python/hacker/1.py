
if __name__ == '__main__':
    n = int(input().strip())

    genes = input().rstrip().split()

    health = list(map(int, input().rstrip().split()))

    s = int(input().strip())

    dic={}
    answer=[]

    for i in range(len(genes)):
        if(genes[i] in dic):
            dic[genes[i]]+=health[i]
        else:
            dic[genes[i]]=health[i]

    for s_itr in range(s):
        first_multiple_input = input().rstrip().split()

        first = int(first_multiple_input[0])

        last = int(first_multiple_input[1])

        d = first_multiple_input[2]

        sum=0
        for i in range(len(d)):
            for j in range(i,len(d)):
                ch=d[i:j]

                if(ch in dic):
                    sum+=dic[ch]

        print(max(answer),min(answer))

#https://www.hackerrank.com/challenges/determining-dna-health/problem?isFullScreen=true

#처음과 끝과 문자열을 주어주면 그 문자열에 genes가 속하는 경우 그 만큼 health 점수를 줌 그리고 모든 케이스중 가장 낮은 경우와 높은 경우를 출력