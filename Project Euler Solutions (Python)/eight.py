'''
Created on Feb 5, 2013

@author: jordan
'''

def main():
    fileString = open("/home/jordan/workspace/python PE/eight.txt")
    numString = fileString.read()
    numString = numString.replace("\n", "")
    maximum = 0
    for x in range(len(numString) - 4):
        currentString = (numString[x:x + 5])
        total = 1
        for y in currentString:
            total *= int(y)
        if total > maximum:
            maximum = total
    print(maximum)
    
    
if __name__ == '__main__':
    main()