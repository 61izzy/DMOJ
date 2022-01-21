n, m, k = map(int, input().split())
tp = [[] for i in range(k + 1)]
arr = []
bruh = 0
for i in range(n):
  t, l = map(int, input().split())
  tp[t].append(l)
for i in range(1, k + 1):
  bruh += max(tp[i])
  tp[i].remove(max(tp[i]))
  arr += tp[i]
if k != m:
  bruh += sum(sorted(arr)[k - m:])
print(bruh)
