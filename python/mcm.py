#!/usr/bin/python

# Matrix Chain Multiplication Problem using recursive method

import sys

class matrix:
    def __init__(self, rows, cols):
        self.rows = rows
        self.cols = cols
        return
    

def mcm(start, end):
    if start == end:
        return 0
    res = sys.maxint
    for i in range(start, end):
        res = min(res,mcm(start,i)+mcm(i+1,end)+(Mat[start].rows*Mat[i].cols*Mat[end].cols))
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
    print mcm(0, int(num_mat)-1)
    return
if __name__ == '__main__':
    main()
