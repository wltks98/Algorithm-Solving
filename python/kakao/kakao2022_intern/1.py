survey=["AN", "CF", "MJ", "RT", "NA"]
choices=[5, 3, 2, 7, 5]

answer=''

dic={'R':0,'C':0,'J':0,'A':0}
type={'R':'T','C':'F','J':'M','A':'N'}

score=[0,3,2,1,0,-1,-2,-3]

for sur,choice in zip(survey,choices):
    a,b=sur
    if a in dic:
        dic[a]+=score[choice]
    else:
        dic[b]-=score[choice]

for key,value in dic.items():
    if value<0:
        answer+=type[key]
    else:
        answer+=key

print(dic)
print(answer)
