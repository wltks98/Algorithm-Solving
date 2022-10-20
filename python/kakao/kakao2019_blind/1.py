record=["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]

dic={}

answer=[]

def st(id,act):

    if act=="Enter":
        ac="들어왔습니다"
    else:
        ac="나갔습니다"

    return dic[id]+"님이 "+ac+'.'

for re in record:
    if re[0] !='L':
        a,b,c=re.split(' ')

        dic[b]=c


for re in record:
    a,b=re.split(" ")[0:2]

    if a!="Change":
        answer.append(st(b,a))

print(answer)