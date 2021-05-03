# KMP算法深入理解及代码实现

KMP算法是经典的字符串匹配算法，它的时间复杂度为$O(N+M)$.
具体地说，KMP算法是基于部分匹配表（PMT）的原理。在部分匹配表中，我们首先计算每个`子串`的`前缀`与`后缀`的`最长公共部分`.

`abab`的`前缀`为`{a,ab,aba}`,`后缀`为`{b,ab,bab}`，最大的公共部分是`ab`，其PMT的值为2.

在计算`next`数组时，我们会将PMT右移，第一位填充-1.
计算PMT表及next数组过程如下。

| string | a    | b    | a    | b    | a    | b    | c    | a    |
| ------ | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| index  | 0    | 1    | 2    | 3    | 4    | 5    | 6    | 7    |
| PMT    | 0    | 0    | 1    | 2    | 3    | 4    | 0    | 1    |
| next   | -1   | 0    | 0    | 1    | 2    | 3    | 4    | 0    |

代码实现：

```python
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        def KMP(s, p):
            """
            s为主串
            p为模式串
            如果t里有p，返回打头下标
            """
            nex = getNext(p)
            i = 0
            j = 0   # 分别是s和p的指针
            while i < len(s) and j < len(p):
                if j == -1 or s[i] == p[j]: # j==-1是由于j=next[j]产生
                    i += 1
                    j += 1
                else:
                    j = nex[j]

            if j == len(p): # j走到了末尾，说明匹配到了
                return i - j
            else:
                return -1

        def getNext(p):
            """
            p为模式串
            返回next数组，即部分匹配表
            """
            nex = [0] * (len(p) + 1)
            nex[0] = -1
            i = 0
            j = -1
            while i < len(p):
                if j == -1 or p[i] == p[j]:
                    i += 1
                    j += 1
                    nex[i] = j     # 这是最大的不同：记录next[i]
                else:
                    j = nex[j]

            return nex
        
        return KMP(haystack, needle)
```

# 