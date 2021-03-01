weight = [] #empty array
planet = input('This program converts weight to what it would weigh on the Moon, Mars, or Saturn. Which planet would you like: ')
if planet.lower() == 'moon'or planet.lower() == 'mars' or planet.lower() == 'saturn':
    NoW = int(input('How many weights would you like to convert?: ')) #user input for Number of Weights to convert
if planet.lower() == 'moon':
    for i in range(NoW):
        weight.append(int(input('Enter weight in lbs: '))) #taking user input and adding into array
        weight[i] = (weight[i]/9.81)*1.622 #taking user input and calculating the weight on the moon
        rweight = [round(x, 2) for x in weight] #rounding to two decimal places
    print ('The weight on the moon would become:',rweight, 'lbs.')
elif planet.lower() == 'mars':
    for i in range(NoW):
        weight.append(int(input('Enter weight in lbs: '))) #taking user input and adding into array
        weight[i] = (weight[i]/9.81)*3.711 #taking user input and calculating the weight on the mars
        rweight = [round(x, 2) for x in weight] #rounding to two decimal places
    print ('The weight on the mars would become:',rweight, 'lbs.')
elif planet.lower() == 'saturn':
    for i in range(NoW):
        weight.append(int(input('Enter weight in lbs: '))) #taking user input and adding into array
        weight[i] = (weight[i]/9.81)*10.44 #taking user input and calculating the weight on the saturn
        rweight = [round(x, 2) for x in weight] #rounding to two decimal places
    print ('The weight on the mars would become:',rweight, 'lbs.')
else:
    print('Please restart and choose a valid entry.')
