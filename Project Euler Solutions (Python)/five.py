'''
Created on Feb 5, 2013

@author: jordan
'''

def main():
    x = 20
    while(not isDiv(x)):
        x += 20
    print(x)
    
def isDiv(x):
    for y in range(21, 1, -1):
        if (x % y != 0):
            return False  
    return True
    
if __name__ == "__main__":
    main()