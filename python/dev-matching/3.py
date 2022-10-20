import math


enroll=["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]
referral=["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]
seller=["young", "john", "tod", "emily", "mary"]
amount=[12, 4, 2, 5, 10]

def dfs(s,a):

    if s==-1:
        return

    if a==0:
        return
    print(a)

    give=math.floor(a/10)
    money[s]+=a-give
    dfs(parent[s],give)

n=len(enroll)

parent=[-1]*n
money=[0]*n

dic={v:i for i,v in enumerate(enroll)}
dic["-"]=-1

for i,r in enumerate(referral):
    parent[i]=dic[r]


for s,a in zip(seller,amount):
    give=math.floor((a*100)/10)
    money[dic[s]]+=a*100-give
    dfs(parent[dic[s]],give)


print(dic)
print(parent)
print(money)