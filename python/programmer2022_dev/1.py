# registered_list=["card","ace13","ace16","banker","ace17","ace14"]
registered_list=["bird99","bird98","bird101","gotoxy"]
new_id="bird98"

arr=[str(i) for i in range(10)]


if(new_id not in registered_list):
    answer=new_id


def find(str):

    if(len(str)==3):
        return 3

    for i in range(3,len(str)):
        if(str[i] in arr):
            return i

index=find(new_id)

string=new_id[:index]
if(len(string)==3):
    num="1"
else:
    num=int(new_id[index:])

print(string,num)

while(new_id in registered_list):
    num+=1
    new_id=string+str(num)

print(new_id)

