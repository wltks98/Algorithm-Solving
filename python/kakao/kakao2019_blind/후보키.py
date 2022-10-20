from itertools import combinations

relation=[["100","ryan","music","2"],["200","apeach","math","2"],["300","tube","computer","3"],["400","con","computer","4"],["500","muzi","music","3"],["600","apeach","music","2"]]

answer=0

combi=[]

row = len(relation)
col = len(relation[0])

for i in range(1, col+1):
    combi.extend(combinations(range(col), i))

unique=[]

for i in combi:
    tmp = [tuple([item[key] for key in i]) for item in relation]
    
    if len(set(tmp))==row:
        put=True

        for x in unique:
            if set(x).issubset(set(i)):
                put = False
                break
        if put:
            unique.append(i)