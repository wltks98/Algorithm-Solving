from itertools import combinations

relation=[["100","ryan","music","2"],["200","apeach","math","2"],["300","tube","computer","3"],["400","con","computer","4"],["500","muzi","music","3"],["600","apeach","music","2"]]

col=len(relation[0])
row=len(relation)

notyet=[i for i in range(col)]
possible=[]

def check(a):
    
    print


for i in range(1,col+1):
    arr=list(combinations(notyet,i))
    print(arr)
    for a in arr:
        if check(a):
            possible.append(a)




