class Endereco
{
    constructor(CEP, UF, cidade, bairro, rua, numero)
    {
        this.CEP = CEP;
        this.UF = UF;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }

    consultarEnderecoViaCEP()
    {
        
    }
}

const inputCEP = document.querySelector('#cep');
inputCEP.value = inputCEP.value.replace(/\D/g, '');

inputCEP.addEventListener('input', () => {
    let CEP = inputCEP.value;
    if (CEP.length == 8)
    {
        consultarEnderecoViaCEP(CEP);
    }
});


function consultarEnderecoViaCEP(CEP)
{
    if(typeof CEP != 'string') {return};

    if (CEP.length != 8) {return};
    
    fetch(`https://viacep.com.br/ws/${CEP}/json/`)
        .then(response => response.json())
        .then(dados => {
            if(dados.erro) return;
            
            let endereco = new Endereco(CEP, dados['uf'], dados['localidade'], dados['bairro'], dados['logradouro'], undefined)

            popularInputsEndereco(endereco);
        })

}


function popularInputsEndereco(endereco)
{
    document.querySelector('#cep').value = endereco['cep'];
    document.querySelector('#uf').value = endereco['UF'];
    document.querySelector('#cidade').value = endereco['cidade'];
    document.querySelector('#bairro').value = endereco['bairro'];
    document.querySelector('#rua').value = endereco['rua'];
    document.querySelector('#numero').value = endereco['numero'] ? endereco['numero'] : '' ;
}