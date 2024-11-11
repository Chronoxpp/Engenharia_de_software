class Carro
{
    constructor(modelo, marca, ano)
    {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
    }

    exibirDados(){
        return `Modelo: ${this.modelo}, Marca: ${this.marca}, Ano: ${this.ano}`;
    }
}


let carros = [];
let indexCarroEmEdicao = null;

const form = document.querySelector('#dadosObjetoCarro');
const carrosHTML = document.querySelector('#carros');


form.addEventListener('submit', 
    (event) => {
        event.preventDefault;

        let modelo = form.querySelector('#modelo').value;
        let marca = form.querySelector('#marca').value;
        let ano = form.querySelector('#ano').value;
        let carro = new Carro(modelo, marca, ano);

        if(indexCarroEmEdicao === null)
        {
            adicionarCarro(carro);
        }
        else
        {
            atualizarCarro(carro);
        }
    }
);


function adicionarCarro(carro)
{
    carros.push(carro);
    listarCarrosHTML();
    limparForm();
}


function atualizarCarro(carro)
{
    carros[indexCarroEmEdicao].marca = carro["marca"];
    carros[indexCarroEmEdicao].modelo = carro["modelo"];
    carros[indexCarroEmEdicao].ano = carro["ano"];
    listarCarrosHTML();
    limparForm();
}


function listarCarrosHTML()
{
    carrosHTML.innerHTML = '';

    carros.forEach(
        (carro,index)=> {
            const li = document.createElement('li');
            let liDados = `${carro.exibirDados()}`;
            liDados += ` - <button onclick='editarCarro(${index})'>Editar</button>`;
            liDados += ` - <button onclick='excluirCarro(${index})'>Excluir</button>`;
            li.innerHTML = liDados;

            carrosHTML.appendChild(li);
        }
    );
}


function limparForm()
{
    form.reset();
    form.querySelector('button').innerText = "Cadastrar";
    indexCarroEmEdicao = null;
}


window.editarCarro = function(index) {
    indexCarroEmEdicao = index;

    form.querySelector('#modelo').value = carros[index].modelo;
    form.querySelector('#marca').value = carros[index].marca;
    form.querySelector('#ano').value = carros[index].ano;

    form.querySelector('button').innerText = "Atualizar";
};


window.excluirCarro = (index) => {
    carros.splice(index, 1);
    listarCarrosHTML();

    if(indexCarroEmEdicao != null)
    {
        if(index === indexCarroEmEdicao)
            limparForm();
        else if(index < indexCarroEmEdicao)
            indexCarroEmEdicao -= 1; //Mantem a lista de carros do script sincronizada com a lista de carros do HTML
    }
};