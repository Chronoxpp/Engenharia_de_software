primo = False
perfeitos = 0
encontrar = 10
pot_atual = 0
somapot = 0
pprimo = 0
cprimo = 0
i = 0

while(perfeitos < encontrar):
    while(primo == False):
        if (pot_atual == 0):
            pot_atual = 2
            somapot = pot_atual
        else:
            pot_atual = pot_atual * 2
            somapot = somapot + pot_atual
        
        pprimo = somapot + 1
        for i in range(2,(pprimo//2)):
            if (pprimo%i == 0):
                cprimo = cprimo + 1

        cprimo = cprimo + 2
        if (cprimo > 2 ):
            primo = False
        else:
            primo = True
        cprimo = 0
        

    primo = False
    
    perfeitos = perfeitos + 1
    print((pprimo*pot_atual))
print("Acabou")