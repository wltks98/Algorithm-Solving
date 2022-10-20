import re

birth=["1899-13-31", "19001231", "2001-09-04", "1900-02-29", "2021-5-31", "1950-11-30", "1996-02-29", "1999-11-31", "2000-02-29"]

answer=0

check=re.compile('\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])')

for b in birth:
    flag=check.match(b)

    if flag:
        y,m,d=b.split('-')
        yy=int(y)
        if 1900<=yy<=2021:

            if m in ('01','03','05','07','08','10','12'):
                if int(d)<=31:
                    answer+=1
                    print(b,'1')
            elif m=='02':
                
                if yy%400==0 or (yy%100!=0 and yy%4==0):
                    if int(d)<=29:
                        answer+=1
                        print(b,'2')
                else:
                    if int(d)<=28:
                        answer+=1
                        print(b,'3')
            else:
                if int(d)<=30:
                    answer+=1
                    print(b,'4')

print(answer)