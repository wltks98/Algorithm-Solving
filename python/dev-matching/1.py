lottos=[44, 1, 0, 0, 31, 25]
win_nums=[31, 10, 45, 1, 6, 19]

dic={0:6,1:6,2:5,3:4,4:3,5:2,6:1}
count=0
zero=0
for lo in lottos:
    if lo in win_nums:
        count+=1
    if lo==0:
        zero+=1

answer=[dic[count+zero],dic[count]]

print(answer)
