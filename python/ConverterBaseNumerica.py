def converterParaAlgarismoHexadecimal(numeroHexadecimal):
    if (numeroHexadecimal == 10):
        return "A"
    elif (numeroHexadecimal == 11):
        return "B"
    elif (numeroHexadecimal == 12):
        return "C"
    elif (numeroHexadecimal == 13):
        return "D"
    elif (numeroHexadecimal == 14):
        return "E"
    elif (numeroHexadecimal == 15):
        return "F"
    else:
        return numeroHexadecimal
    
def inverterValorQualquer(valorQualquer = []):
    valorInvertido = ""
    for i in range((len(valorQualquer)-1),0,-1):
        valorInvertido = valorInvertido + str(valorQualquer[i])
    
    return valorInvertido

def converterNumeroNaBaseDesejada(decimal,baseNumerica):
    numeroNaBaseDesejada = []

    if(decimal < baseNumerica):
        if(baseNumerica == 16):
                return converterParaAlgarismoHexadecimal(decimal)
        else:
            return decimal
    else:
        while(decimal >=baseNumerica):
            if(baseNumerica == 16):
                numeroNaBaseDesejada.append(converterParaAlgarismoHexadecimal(decimal%baseNumerica))
                decimal = decimal//baseNumerica
            else:
                numeroNaBaseDesejada.append((decimal%baseNumerica))
                decimal = decimal//baseNumerica

        if(baseNumerica == 16):
            numeroNaBaseDesejada.append(converterParaAlgarismoHexadecimal(decimal)) 
        else:
            numeroNaBaseDesejada.append((decimal))
        
        return  inverterValorQualquer(numeroNaBaseDesejada)

def preencherVetorDecimal(vetorDecimal = []):
    for i in range(0,256):
        vetorDecimal.append(i)
            
    return vetorDecimal

def converterArrayDecimalParaBinario(vetorDecimal = []):
    vetorBinario = []
    for numeroDecimal in vetorDecimal:
        vetorBinario.append(converterNumeroNaBaseDesejada(numeroDecimal,2))
    
    return vetorBinario
        
def exibirDadosDosVetores(vetor = []):
    for i in range(0,256):
        print(vetor[i])


numerosNaBaseDecimal = []
numerosNaBaseDecimal = preencherVetorDecimal(numerosNaBaseDecimal)

numerosNaBaseBinario = []
numerosNaBaseBinario = converterArrayDecimalParaBinario(numerosNaBaseDecimal)

exibirDadosDosVetores(numerosNaBaseBinario)
