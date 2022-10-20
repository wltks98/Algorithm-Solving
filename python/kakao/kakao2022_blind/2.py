import math

n=437674
k=3

def isPrime(a):
  if(a<2):
    return False
  for i in range(2,a):
    if(a%i==0):
      return False
  return True

def jinsu(n, q):
    rev_base = ''

    while n > 0:
        n, mod = divmod(n, q)
        rev_base += str(mod)

    return rev_base[::-1]


answer=0
num=jinsu(n,k)

print(num)

ch=''
for i in range(len(num)):
    print(num[i])
    if num[i]!='0':
        ch+=num[i]     
    elif num[i]=='0':
        if ch:
            
            if isPrime(int(ch)):
                answer+=1
                ch=''
                

if ch:
    
    if isPrime(int(ch)):
        answer+=1

print(answer)

