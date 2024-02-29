numero = 0
numero = int(input("Insira um numero inteiro e positivo: "))
parar = False

while (parar == False):
    print(numero%10, end="")
    numero = (numero//10)

    if(numero//10 == 0) and (numero%10 == 0):
        parar = True
    else:
        parar = False