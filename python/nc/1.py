from collections import Counter


movie=["spy","ray","spy","room","once","ray","spy","once"]
dic={}

for m in movie:
    if m in dic:
        dic[m]+=1
    else:
        dic[m]=1



di=sorted(dic,key=lambda x:(-dic[x],x))

print(di)
