'''
Created on Feb 5, 2013

@author: jordan
'''

palindromes = []
for x in range (999):
    for y in range (999):
        result = x * y
        if (str(result) == str(result)[::-1]):
            palindromes.append(result)
print(max(palindromes))

