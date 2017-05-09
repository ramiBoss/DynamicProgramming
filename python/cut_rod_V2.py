#!/usr/bin/python

# Rod Cutting Problem using Dynamic Programming's Bottom-Up Approach

def cut_rod(p, n):
    dp = [-1000]*(n+1)
    return cut_rod_aux(p, dp, n)

def cut_rod_aux(p, dp, n):
    dp[0] = 0
    for i in range(1, n+1):
        q = p[i]
        for j in range(1, i+1):
            q = max(q, p[j]+dp[i-j])
        dp[i] = q
    return dp[n]

def main():
    price_table = [0,1,5,8,9,10,17,17,20,24,30]
    n = raw_input('Enter size of the rod')
    print cut_rod(price_table, int(n))
    return

if __name__ == '__main__':
    main()
