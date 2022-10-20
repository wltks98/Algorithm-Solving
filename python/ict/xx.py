arr=[1,5,5,1]
threshold=2

n=len(arr)

min=int(1e9)

def dfs(num,set_count,ans,arr):

    n=len(arr)
  
    array=arr[num:num+set_count]
    ans+=max(array)

    if(num+set_count==n):
        return ans

    m=int(1e9)

    for j in range(1,threshold+1):
        if(num+set_count+j<=n):
            ans2=dfs(num+set_count,j,ans,arr)
            if(ans2<m):
                m=ans2
    return m

        
for j in range(1,threshold+1):
    
    ans=dfs(0,j,0,arr)
    print(ans)
    if(ans<min):
        min=ans

print(min)