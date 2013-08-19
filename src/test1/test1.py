# encoding=UTF-8
'''
Created on 2013-7-30
@author: Corleone
generate 4000000000 (40亿)个40亿以内的数字
找出不在里面的一个数字
1、只有1G内存，如何找？
2、只有10M内存，如何找？
'''
from random import randrange
import datetime

if __name__ == '__main__':

    now = datetime.datetime.now()
    with open(r'd:\test\review2.txt', 'w') as f:
        for i in xrange(2000000000):
            if i % 1000000 == 0:
                print i, u'use ' , datetime.datetime.now() - now
            for j in range(2):
                f.write(str(randrange(0, 4000000000, 1)) + ",")

    print u'use ' , datetime.datetime.now() - now
                    
    
    
