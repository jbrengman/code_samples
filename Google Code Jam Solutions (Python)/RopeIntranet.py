'''
Created on Feb 6, 2013

@author: jordan
'''

def main():
    inputFile = open('/home/jordan/workspace/python code jam/RopeIntranet.in')
    cases = int(inputFile.readline())
    outString = ''
    for eachCase in range(cases):
        intersects = 0
        verticesList = []
        wires = int(inputFile.readline())
        for eachWire in range(wires):
            vertices = inputFile.readline().split()
            verticesList.append(vertices)
        for eachWire in range(wires):
            left = int(verticesList[eachWire][0])
            right = int(verticesList[eachWire][1])
            for checkWire in range(eachWire + 1, wires):
                chkLeft = int(verticesList[checkWire][0])
                chkRight = int(verticesList[checkWire][1])
                if (not((left > chkLeft and right > chkRight) or 
                         left < chkLeft and right < chkRight)):
                    intersects += 1
        outString += 'Case #%s: %s\n'%(str(eachCase + 1), intersects)
    outFile = open('/home/jordan/workspace/python code jam/RopeIntranet.out', 'w')
    outFile.write(outString)

        

if __name__ == '__main__':
    main()