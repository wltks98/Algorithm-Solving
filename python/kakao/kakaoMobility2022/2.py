from collections import defaultdict

def solution(id_list, k):

    dic=defaultdict(int)
    answer=0
    
    for users in id_list:
        for user in set(users.split()):
            dic[user]+=1

    for value in dic.values():
        if value<=k:
            answer+=value
        else:
            answer+=k

    return answer