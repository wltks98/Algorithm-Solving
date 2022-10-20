a=24
b=8



def gcd(a,b):
    while b:
        c=a%b
        a=b
        b=c
    return a

n1=gcd(a,b)
n2=a*b//n1

print(n1,n2)