# 并查集模版python


```python
class UF:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.area = n

    def union(self, p, q):
        r1 = self.find(p)
        r2 = self.find(q)
        if r1!=r2:
            self.parent[r1] = r2
            self.area -= 1

    def find(self, p):
        root = p
        while root!=self.parent[root]:
            root = self.parent[root]

        # 路径压缩
        x = p
        while x!=self.parent[x]:
            n = self.parent[x]
            self.parent[x] = root
            x = n
        return root
```

