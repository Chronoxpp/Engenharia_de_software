class Carro {
    constructor(marca, modelo, ano){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }
    exibirCarro(){
        return `${this.marca} | ${this.modelo} | ${this.ano}`;
    }
}

let carros = []; // criação do vetor de armazenamento de dados
let edIndex = null;

const form = document.querySelector("#formularioCarro");
const listaCarros = document.querySelector("#listaDeCarros");

function exibirLista(){
    listaCarros.innerHTML = ''; // está vazia
    // iteração pelos carros
    function minhafuncao(arg1, arg2)
    {
        asdasdasdasdasdas
    }
    for(a : ba)
    {
        sdfsdfsdfsdfsdffsdf
        sdfsdfsdfsdfsdffsdf
    }

    carros

    carros.forEach( (carro, index) => {
        // criar a tag <li></li>
        const li = document.createElement('li');
        // popular valores para o li, contendo (carro <editar> <excluir>)
        li.innerHTML = `${carro.exibirCarro()}
                        <button onclick='editarCarro(${index})'>Editar</button>
                        <button onclick='excluirCarro(${index})'>Excluir</button>`;
        // popular o "listaCarros"
        listaCarros.appendChild(li);
    });
}

// Adicionar/Atualizar o carro - addEventListener
form.addEventListener("submit", function(event){
    event.preventDefault();
    
    const marca = document.querySelector("#marca").value;
    const modelo = document.querySelector("#modelo").value;
    const ano = document.querySelector("#ano").value;

    if (edIndex === null){
        const car = new Carro(marca, modelo, ano);
        carros.push(car);
    }else{
        carros[edIndex].marca = marca;
        carros[edIndex].modelo = modelo;
        carros[edIndex].ano = ano;
        edIndex = null;
        form.querySelector("button").innerText = "Adicionar Carro";
    }
    form.reset();
    exibirLista();
});

// Botão Editar o Carro
window.editarCarro = function(index){ // modals
    edIndex = index;
    document.querySelector('#marca').value = carros[index].marca;
    document.querySelector('#modelo').value = carros[index].modelo;
    document.querySelector('#ano').value = carros[index].ano;
    form.querySelector("button").innerText = "Atualizar Carro";
};

// Botão Excluir o carro
window.excluirCarro = function(index){
    carros.splice(index, 1);
    form.reset();
    form.querySelector("button").innerText = "Adicionar Carro";
    exibirLista();
}
exibirLista();