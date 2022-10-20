import itertools

work_hours = 56
day_hours = 8
pattern = '???8???'

# work_hours = 24
# day_hours = 4
# pattern = '08??840'

answer=[]
empty=0

summ=0
for p in pattern:
    if(p!='?'):
        num=int(p)
        summ+=num
    else:
        empty+=1

time=work_hours-summ #4, 자리는 2개

arr=[i for i in range(day_hours)]

arr=list(itertools.product(arr,repeat=empty))

for a in arr:
    pat=pattern
    if(sum(a)==time):
        for i in range(len(a)):
            pat=pat.replace('?',str(a[i]),1)

        answer.append(pat)

print(answer)




