def listFunc(a, b):
    return [i for i in range(a, b)] #Create list of ints from 1 to 5, Haskell equivalent [1..5]

def applicatorFunc(inpFunc, s):
    if s=='s':
        return sum(inpFunc(1, 6))
    else:
        return sum(inpFunc(1, 6))/5

print(applicatorFunc(listFunc, 's'))