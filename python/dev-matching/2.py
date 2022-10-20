rows=6
colmuns=6
queries=[[2,2,5,4],[3,3,6,6],[5,1,6,3]]

pre=[[i for i in range((j-1)*colmuns+1,j*colmuns+1)] for j in range (1,rows+1)]
now=[[i for i in range((j-1)*colmuns+1,j*colmuns+1)] for j in range (1,rows+1)]


for q in queries:
    r1,c1,r2,c2=q

    r1-=1
    c1-=1
    r2-=1
    c2-=1

    for i in range(r1,r2+1): 
        for j in range(c1,c2+1):
            if(i==r1 or i==r2):
                if(i==r1 and j==c1):
                    now[i][j]=pre[i+1][j]
                else:
                    now[i][j]=pre[i][j-1]
            else:
                if(j==c2):
                    now[i][j]=pre[i-1][j]
                else:
                    now[i][j]=pre[i][j+1]
    
    pre=now.copy()

print(now)