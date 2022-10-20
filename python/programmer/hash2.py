clothes=[["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]

dic={}

for a,b in clothes:
    if(b in dic):
        dic[b]+=1
    else:
        dic[b]=1

answer=0

if(len(dic)==1):
    answer=dic[list(dic.keys())[0]]

else:
    answer=1
    for key in dic:
        answer*=(dic[key]+1)
    answer-=1

print(answer)