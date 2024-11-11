class Tarefa
{
    constructor(resumo, descricao, prazoConclusao, concluida)
    {
        this.resumo = resumo;
        this.descricao = descricao;
        this.prazoConclusao = prazoConclusao;
        this.concluida = concluida;
    }

    exibirDados(){
        return `Resumo: ${this.resumo}, Descricao: ${this.descricao}, Prazo de conclusao: ${this.prazoConclusao}`;
    }
}


let tarefas = [];
let indexTarefaEmEdicao = null;

const form = document.querySelector('#tarefa');
const tarefasHTML = document.querySelector('#tarefas');


form.addEventListener('submit', 
    (event) => {
        event.preventDefault();

        let resumo = form.querySelector('#resumo').value;
        let descricao = form.querySelector('#descricao').value;
        let prazoConclusao = form.querySelector('#prazo').value;
        let concluida = form.querySelector('#concluida').checked;

        let tarefa = new Tarefa(resumo, descricao, prazoConclusao, concluida);

        if(indexTarefaEmEdicao === null)
        {
            adicionarTarefa(tarefa);
        }
        else
        {
            atualizarTarefa(tarefa);
        }
    }
);


function adicionarTarefa(tarefa)
{
    tarefas.push(tarefa);
    listarTarefasHTML();
    limparForm();
}


window.limparForm = function()
{
    form.reset();
    form.querySelector('button').innerText = "Adicionar";
    indexTarefaEmEdicao = null;
};


function atualizarTarefa(tarefa)
{
    tarefas[indexTarefaEmEdicao].resumo = tarefa['resumo'];
    tarefas[indexTarefaEmEdicao].descricao = tarefa['descricao'];
    tarefas[indexTarefaEmEdicao].prazoConclusao = tarefa['prazoConclusao'];
    tarefas[indexTarefaEmEdicao].concluida = tarefa['concluida'];
    listarTarefasHTML();
    limparForm();
}


function listarTarefasHTML()
{
    tarefasHTML.innerHTML = '';

    tarefas.forEach(
        (tarefa,index)=> {
            const li = document.createElement('li');
            li.innerHTML = `${tarefa.exibirDados()}`;
            li.innerHTML += `- <button onclick='editarTarefa(${index})'>Editar</button>`;
            li.innerHTML += `- <button onclick='excluirTarefa(${index})'>Excluir</button>`;

            tarefasHTML.appendChild(li);
        }
    );
}


window.editarTarefa = (index) => {
    indexTarefaEmEdicao = index;

    form.querySelector('#resumo').value = tarefas[index]['resumo'];
    form.querySelector('#descricao').value = tarefas[index]['descricao'];
    form.querySelector('#prazo').value = tarefas[index]['prazoConclusao'];
    form.querySelector('#concluida').checked = tarefas[index]['concluida'];

    form.querySelector('button').innerText = "Atualizar";
};


window.excluirTarefa = (index) => {
    tarefas.splice(index, 1);
    listarTarefasHTML();

    corrigirAposExclusaoIndexTarefaEmEdicao(index);
};


function corrigirAposExclusaoIndexTarefaEmEdicao(indexTarefaExcluida)
{
    if(indexTarefaEmEdicao != null)
    {
        if(indexTarefaExcluida === indexTarefaEmEdicao)
            limparForm();

        // Verifica se a tarefa excluída está antes da tarefa em edição.
        else if(indexTarefaExcluida < indexTarefaEmEdicao)
            indexTarefaEmEdicao -= 1; // Ajusta o índice, pois no HTML ele ja desceu uma posicao.
    }
}

