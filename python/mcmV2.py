#!/usr/bin/python

import sys

class matrix:
    def __init__(self, rows, cols):
        self.rows = rows
        self.cols = cols
        return
    
def mcm_init(start, end):
    global dp
    global sol
    dp = [[0 for i in range(end+1)] for j in range(end)]
    sol = [[0 for i in range(end+1)] for j in range(end)]
    return mcm(dp, start, end)

def mcm(dp, start, end):
    if start == end:
        return 0

    if dp[start][end] != 0:
        return dp[start][end]
    
    if Mat[start].cols != Mat[start+1].rows:
        print 'Incompatible Matrix Entries '
        sys.exit(1)
        
    res = sys.maxint
    for i in range(start, end):
        res_aux = min(res,mcm(dp, start, i)+mcm(dp, i+1, end)+(Mat[start].rows*Mat[i].cols*Mat[end].cols))
        if res_aux < res:
            sol[start][end] = i
        res = res_aux    
    dp[start][end] = res
    return res


def main():
    global Mat
    print '*** Matrix Chain Multiplication ***'
    print 'Enter the number of matrices'
    Mat = []
    num_mat = raw_input()
    for i in range(int(num_mat)):
        print 'Matrix ', i, 'rows: ',
        rows = raw_input()
        print 'Matrix ', i, 'cols: ',
        cols = raw_input()
        mat = matrix(int(rows), int(cols))
        Mat.append(mat)
    #print Mat
    print mcm_init(0, int(num_mat)-1)
    print 'The memoized matrix'
    print dp
    print 'The matrices are divided at: '
    #while(sol[start][sol[start][end]] || sol[sol[start][end]+1][end]):
        #print 
    print sol
    return
if __name__ == '__main__':
    main()    
