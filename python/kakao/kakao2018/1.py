class Trie:
    def __init__(self):
        self.root = {}

    def add(self, words):
        cur = self.root

        for ch in words:
            if ch not in cur:
                cur[ch] = [0,{}]  

            cur[ch][0]+=1
            cur = cur[ch][1]

	
    def find(self,word):
        cur=self.root
        i=0
        for ch in word:
            i+=1
            if cur[ch][0]==1:
                return i
            cur=cur[ch][1]                      
        return i

def solution(words):
    answer = 0
    
    trie=Trie()
    
    for word in words:
        trie.add(word)
    for word in words:
        answer+=trie.find(word)    
    return answer

print(solution(["go","gone","guild"]))