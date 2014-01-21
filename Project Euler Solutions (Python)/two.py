'''
Created on Feb 5, 2013

@author: jordan
'''

current = 1
incr = 0
temp = 0
total = 0
while (current <= 4000000):
    if (current % 2 == 0):
        total += current
    temp = current
    current += incr
    incr = temp
    
print(total)