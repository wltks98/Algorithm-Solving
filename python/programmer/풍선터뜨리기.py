a=[-16,27,65,-2,58,-92,-71,-68,-61,-33]

n=len(a)

left=[0]*n
right=[0]*n

l_min=a[0]
r_min=a[-1]

answer=2

for i in range(n):
    if(l_min>a[i]):
        l_min=a[i]
    left[i]=l_min

    if(r_min>a[n-i-1]):
        r_min=a[n-i-1]
    right[n-i-1]=r_min

for i in range(1,n-1):
     if left[i-1] > a[i] or right[i+1] > a[i]:
            answer += 1