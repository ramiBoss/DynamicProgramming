#!/usr/bin/python

# Rod Cutting Problem Using Dynamic Programming's Top-Down Approach

def cut_rod(p, n):
    dp = [-10000]*(n+1)
    return cut_rod_aux(p, dp, n)

def cut_rod_aux(p, dp, n):
    if(n <= 0):
        return 0
    if(dp[n] >= 0):
        return dp[n]
    q = p[n]
    for i in range(1, n):
        q = max(q, p[i]+cut_rod_aux(p, dp, n-i))
    dp[n] = q
    return q

def main():
    price_table = [0,1,5,8,9,10,17,17,20,24,30]
    n = raw_input('Enter size of the rod')
    print cut_rod(price_table, int(n))
    return
if __name__ == '__main__':
    main()
