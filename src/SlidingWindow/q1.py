class TrieNode:
    def __init__(self):
        self.children = {}
        self.fail = None
        self.output = []

class AhoCorasick:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
        node.output.append(word)

    def build(self):
        from collections import deque
        queue = deque()
        for node in self.root.children.values():
            node.fail = self.root
            queue.append(node)
        while queue:
            current_node = queue.popleft()
            for char, next_node in current_node.children.items():
                fail_node = current_node.fail
                while fail_node is not None and char not in fail_node.children:
                    fail_node = fail_node.fail
                next_node.fail = fail_node.children[char] if fail_node else self.root
                next_node.output += next_node.fail.output if next_node.fail else []
                queue.append(next_node)

    def search(self, text):
        node = self.root
        positions = []
        for i in range(len(text)):
            while node is not None and text[i] not in node.children:
                node = node.fail
            if node is None:
                node = self.root
                continue
            node = node.children[text[i]]
            if node.output:
                for pattern in node.output:
                    positions.append((i - len(pattern) + 1, i))
        return positions

def censor_text(text, patterns):
    ac = AhoCorasick()
    for pattern in patterns:
        ac.insert(pattern)
    ac.build()
    positions = ac.search(text)
    result = list(text)
    for start, end in positions:
        for i in range(start, end + 1):
            result[i] = '*'
    return ''.join(result)

if __name__ == '__main__':
    n = int(input().strip())
    S = input().strip()
    patterns = [input().strip() for _ in range(n)]
    print(censor_text(S, patterns))
