def minion_game(string):
    string = string.lower()
    vowels = ['a','e','i','o','u'] # ['aeiou']
    vowel_index = []
    for i in range(len(string)):
        if string[i] in vowels:
            vowel_index.append(i)
    substr_v = []
    for i in vowel_index:
        for j in range(i+1,len(string)+1):
            substr_v.append(string[i:j])

    cons_ind=[]
    for i in range(len(string)):
        if string[i] not in vowels:
            cons_ind.append(i)
    substr_c = []
    for i in cons_ind:
        for j in range(i+1,len(string)+1):
            substr_c.append(string[i:j])

    if len(substr_c) > len(substr_v):
        print('Stuart', len(substr_c))
    elif len(substr_c) < len(substr_v):
        print('Kevin', len(substr_v))
    else:
        print('Draw')
        return

if __name__ == '__main__':
    s = input()
    minion_game(s)