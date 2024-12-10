class Endereco
{
    constructor(CEP = '', UF = '', cidade = '', bairro = '', rua = ''){
        this.setCEP = function(cep) {CEP = cep;};
        this.getCEP = function() {return CEP};

        this.setUF = function(uf) {UF = uf;};
        this.getUF = function() {return UF;};
    }

    consultarEnderecoViaCEP()
    {

    }
}


const inputCEP = document.querySelector('#cep');

inputCEP.addEventListener('input', () => {
    inputCEP.value = inputCEP.value.replace(/\D/, '');

    let cep = inputCEP.value;

    if (cep.length != 8) {return;}

    fetch(`https://viacep.com.br/ws/${cep}/json/`)
    .then(response => response.json())
    .then(dados => {
        if (dados.erro)
        {
            alert('CEP invalido ou endereço inexisnte!')
            return;
        }

        document.querySelector('#UF').value = dados['uf'];
        document.querySelector('#cidade').value = dados['localidade'];
        document.querySelector('#bairro').value = dados['bairro'];
        document.querySelector('#rua').value = dados['logradouro'];
    });
});