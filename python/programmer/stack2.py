from cgi import print_arguments


priorities=[1, 1, 9, 1, 1, 1]
location=0


answer=0

maxn=max(priorities)

while priorities:

    num=priorities.pop(0)
    if(num==maxn):
        answer+=1
        if(location==0):
            break
        else:
            location-=1
        
        maxn=max(priorities)
    else:
        priorities.append(num)
        if location==0:
            location=len(priorities)-1
        else:
            location-=1

print(answer)