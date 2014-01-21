'''
Created on Feb 21, 2013

@author: jordan
'''

def main():
    inputFile = open('/home/jordan/workspace/python code jam/FileFixIt.in')
    outputFile = open('/home/jordan/workspace/python code jam/FileFixIt.out', 'w')
    outputString = doIt(inputFile)
    outputFile.write(outputString)
    
def doIt(inputFile):
    outputString = ''
    testCases = int(inputFile.readline())
    for x in range(testCases):
        total = 0
        splitThis = inputFile.readline()
        split = splitThis.split(' ')
        numExist = int(split[0])
        numNew = int(split[1])
        filePathList = []
        
        for y in range(numExist):
            thisLine = inputFile.readline().rstrip('\n').split('/')
            thisLine = thisLine[1:]
            for z in range(len(thisLine)):
                if z >= len(filePathList):
                    filePathList.append(set([]))
                filePathList[z].add(thisLine[z])
                print(thisLine[z])
        
        for y in range(numNew):
            thisLine = inputFile.readline().rstrip('\n').split('/')
            thisLine = thisLine[1:]
            print(thisLine)
            for z in range(len(thisLine)):
                if z >= len(filePathList):
                    filePathList.append(set([]))
                if not thisLine[z] in filePathList[z]:
                    filePathList[z].add(thisLine[z])
                    total += 1
                    print(thisLine[z])
                    
        outputString += 'Case #%s: %s\n'%(x + 1, total)
        print(outputString)
    
    
    return outputString

if __name__ == '__main__':
    main()