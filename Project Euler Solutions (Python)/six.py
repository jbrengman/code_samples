'''
Created on Feb 5, 2013

@author: jordan
'''

def main():
    squareSum = 0
    regSum = 0
    for x in range(101):
        regSum += x
        squareSum += x ** 2
    print(regSum ** 2 - squareSum)

if __name__ == '__main__':
    main()