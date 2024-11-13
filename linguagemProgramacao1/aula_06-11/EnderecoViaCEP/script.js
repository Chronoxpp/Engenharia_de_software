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
        if(this.CEP.length !== 8) {return;}

        if((typeof this.CEP) !== 'string') 
        {
            alert('Digite um CEP valido !!');
            return;
        };

        return fetch(`https://viacep.com.br/ws/${this.CEP}/json/`)
            .then(response => response.json())
            .then(dados => {
                if(dados.erro) 
                {
                    alert('CEP invalido ou endereco inexistente !!');
                    return;
                }

                // Atualizando as propriedades do objeto
                this.UF = dados.uf;
                this.cidade = dados.localidade;
                this.bairro = dados.bairro;
                this.rua = dados.logradouro;
                this.numero = ''; // Número não vem na API
            });
    }
}


const inputCEP = document.querySelector('#cep');
inputCEP.value = inputCEP.value.replace(/\D/g, '');

inputCEP.addEventListener('input', () => {
    inputCEP.value = inputCEP.value.replace(/\D/g, '');

    let CEP = inputCEP.value;

    let endereco = new Endereco(CEP);

    endereco.consultarEnderecoViaCEP().then(() => {
        popularInputsEndereco(endereco);
    });
});


function popularInputsEndereco(endereco)
{
    document.querySelector('#cep').value = endereco['CEP'];
    document.querySelector('#uf').value = endereco.UF;
    document.querySelector('#cidade').value = endereco['cidade'];
    document.querySelector('#bairro').value = endereco['bairro'];
    document.querySelector('#rua').value = endereco['rua'];
    document.querySelector('#numero').value = endereco['numero'] ? endereco['numero'] : '' ;
}