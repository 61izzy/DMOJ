n, c, m = map(int, input().split())
t = {}
p = True
avg = 0
for i in range(n):
  temp = input().split()
  t["".join(temp[:-1])] = int(temp[-1])
for i in range(m):
  temp = "".join(input().split())
  if temp in t:
    avg += t[temp]
    t.pop(temp)
  else:
    p = False
avg += sum(sorted(t.values())[m - c:])
avg /= c
print("Ace is dunzos" if n < c or not p else "{:.2f}".format(avg))
