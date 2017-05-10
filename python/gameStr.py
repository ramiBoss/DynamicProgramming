#!/usr/bin/python

# Optimal Game Pick Strategy


class picks:
    def __init__(self, p1, p2):
        self.player1 = p1
        self.player2 = p2
        return
    
def game_pick(n):
    global dp
    dp = [[ picks(0, 0) for i in range(n)] for j in range(n)]
    for i in range(n):
        for j in range(i+1):
            dp[i][j] = picks(array[i], 0)
            
    for i in range(0, n):
        for j in range(0, n):
            print '(', dp[i][j].player1, ',', dp[i][j].player2, ')  ',
        print '\n'
        
    for k in range(1, n):
        j = 0
        for i in range(k, n):
            if(array[j]+dp[j+1][i].player2 > array[i]+dp[j][i-1].player2):
                dp[j][i].player1 = array[j]+dp[j+1][i].player2
                dp[j][i].player2 = dp[i][j+1].player1
                
            else:
                dp[j][i].player1 = array[i]+dp[j][i-1].player2
                dp[j][i].player2 = dp[j][i-1].player1
                #dp[j][i].player1 = max(array[j]+dp[i][j+1].player2, array[i]+dp[j][i-1].player2)
            j = j+1

    print '\n*** After ***\n'
    for i in range(0, n):
        for j in range(0, n):
            print '(', dp[i][j].player1, ',', dp[i][j].player2, ')  ',
        print '\n'  
                
    return 

def main():
    global array
    array = [3,9,1,2]
    game_pick(len(array))
    print 'Maximum Collected By Player 1: ', dp[0][len(array)-1].player1
    print 'Maximum Collected By Player 2: ', dp[0][len(array)-1].player2
    return

if __name__ == '__main__':
    main()
