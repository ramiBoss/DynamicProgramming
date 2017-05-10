#!/usr/bin/python

# Minimum Cost Path Problem

def min_cost_path(mat):
    dp = [[0 for i in range(cols)] for j in range(rows)]
    dp[0][0] = mat[0][0]
    for i in range(1, cols):
        dp[0][i] = dp[0][i-1]+mat[0][i]
    for j in range(1, rows):
        dp[j][0] = dp[j-1][0]+mat[j][0]
    for i in range(1, rows):
        for j in range(1, cols):
            dp[i][j] = min(dp[i-1][j], dp[i][j-1])+mat[i][j]
    print 'Path: ',
    i = rows-1
    j = cols-1
    path = []
    while(i > 0 or j > 0):
        path.append(mat[i][j])
        if(dp[i-1][j] < dp[i][j-1]):
            i = i-1
        else:
            j = j-1
    path.append(mat[i][j])
    #print path
    for k in range(len(path)-1, -1, -1):
        print path[k], '->',
    print 'end'
    return dp[rows-1][cols-1]

def main():
    global rows, cols
    rows = 3
    cols = 4
    mat = [[1,3,5,8], [4,2,1,7], [4,3,2,3]]
    print mat
    print min_cost_path(mat)
    return

if __name__ == '__main__':
    main()
