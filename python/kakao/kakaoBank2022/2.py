money=12345678
minratio=10
maxratio=20
ranksize=250000
threshold=10000000
months=4

import math

def solution(money,minratio,maxratio,ranksize,threshold,months):

    for _ in range(months):

        tax=0

        tmpMoney=math.floor(money/100)*100

        if tmpMoney<threshold:
            tax=0
        else:
            rate=(tmpMoney-threshold)//ranksize

            taxRate=minratio+rate
            if taxRate>maxratio:
                taxRate=maxratio
            tax=tmpMoney*taxRate/100
        
        money-=tax

    return int(money)


print(solution(money,minratio,maxratio,ranksize,threshold,months))