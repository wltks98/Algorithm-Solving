for i in range(5):
    n=input()
    a=0
    for j in range(0,len(n),2):
        a+=int(n[j])
    for j in range(1,len(n),2):
        if n[j]!="0":
            a*=int(n[j])
    print(a%10)

