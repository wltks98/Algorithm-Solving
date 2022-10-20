
phone_book=["12","123","1235","567","88"]


answer=True

dic={a:1 for a in phone_book}

for num in phone_book:
    pre=''
    for i in num:
        pre+=i
        if(pre in dic and pre != num):
            answer=False


