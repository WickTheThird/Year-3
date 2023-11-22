from queue import Queue

def find_num(n):
    vis = [0] * (n + 1)
    vis[1] = 1

    q = Queue()
    q.put(1)

    while not q.empty():
        s = q.get()

        if s == 0:
            return vis[s]
    
        a = (s * 10) % n
        b = (s * 10 + 1) % n
    
        if vis[a] == 0:
            q.put(a)
            vis[a] = vis[s] * 10

        if vis[b] == 0:
            q.put(b)
            vis[b] = vis[s] * 10 + 1

    return -1

total = 0
for i in range(1, 4):
    total += find_num(i) // i

print(total, len(str(total)))
