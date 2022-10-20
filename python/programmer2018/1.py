import itertools

def isPrime(a):
  if(a<2):
    return False
  for i in range(2,a):
    if(a%i==0):
      return False
  return True

nums=[1,2,7,6,4]
result=0


a=list(itertools.combinations(nums,3))

for i in a:
    n=sum(i)
    if(isPrime(n)):
        result+=1

print(result)
