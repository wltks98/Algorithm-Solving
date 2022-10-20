#https://cotak.tistory.com/3
#https://dreamtreeits.tistory.com/35

from sys import stdin
n = int(stdin.readline())


class Trie:
    def __init__(self):
        self.root = {}

    def insert(self, s):
        cur_node = self.root
        for c in s:
            if c not in cur_node:
                cur_node[c] = {}
            cur_node = cur_node[c]
        cur_node['*'] = {}

    def print_trie(self, l, cur_node=None):
        if l == 0:
            cur_node = self.root

        for c in sorted(cur_node.keys()):
            if c != '*':
                print('--' * l, c, sep="")
            self.print_trie(l + 1, cur_node[c])


trie = Trie()
for _ in range(n):
    data = list(stdin.readline().split())
    trie.insert(data[1:])

trie.print_trie(0)

