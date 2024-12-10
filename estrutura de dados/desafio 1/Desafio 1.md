A equipe deverá documentar essa atividade, apresentando quais os resultados
alcançados em cada Passo executado. Para isso, deverão apresentar:
___
1. **Qual o método de busca com melhor desempenho computacional?**

O método de busca com melhor desempenho computacional é a **busca binária**, cuja complexidade é **O(log N)**, sendo **N** a quantidade de elementos na lista. Para fins de comparação, foi realizado um teste com um vetor ordenado contendo cem mil elementos do tipo _double_. Ao solicitar a busca de um elemento inexistente, observou-se que a pesquisa sequencial realizou **100.000** comparações, e a pesquisa sequencial com sentinela apresentou o mesmo desempenho. Em contrapartida, a busca binária realizou apenas **34 comparações** para determinar que o elemento não estava presente no vetor.
___
2.  **Indicar o desempenho da busca binária x busca linear x busca linear com sentinela:
descrever se compensa ordenar uma base de dados para então recuperar a
informação com a busca binária ou se uma outra busca foi mais eficaz nos testes
realizados**

Em relação ao desempenho, ao comparar a pesquisa sequencial simples com a pesquisa sequencial com sentinela, não foi constatada variação significativa em termos de eficiência, já que ambos os algoritmos possuem complexidade **O(N)** no pior caso. Por outro lado, a introdução da **busca binária** demonstrou desempenho significativamente superior, devido à sua complexidade **O(log N)**, realizando muito menos comparações para concluir as pesquisas. Contudo, esse benefício só é alcançado quando o vetor está previamente ordenado.

A decisão de implementar a busca binária depende do contexto e da frequência de uso. Por exemplo:

- Caso as pesquisas sejam realizadas **esporadicamente** ou em listas **menores**, a busca sequencial pode ser mais prática e eficiente, pois não exige o custo adicional de ordenação.
- Em situações em que as buscas são realizadas de forma **frequente** e em listas extensas, a busca binária torna-se vantajosa, mesmo considerando o custo inicial de ordenação, pois o ganho em eficiência durante as consultas compensa o processamento inicial gasto.

Em listas pequenas, a escolha entre os métodos depende da demanda. Se o volume de dados e a frequência de pesquisas forem baixos, considero a busca sequencial como suficiente. Porém, se a lista for propensa a crescimento e consultas frequentes, é mais interessante ordena-la e implementar a busca binaria assim que possível, obtendo o custo reduzido de ordenar listas menores e os benefícios futuros.

Em resumo, a adoção da busca binária depende de fatores como:

- Frequência das consultas;
- Tamanho inicial e potencial expansão da lista.
___
3. **Qual foi a conclusão da equipe nessa bateria de testes?**

A principal conclusão é a compreensão de como os algoritmos de pesquisa e ordenação funcionam. Para quais situações **há algoritmos são mais vantajosos que outros**, e em quais situações são piores que outros. Outro aprendizado importante é que **problemas distintos exigem soluções específicas**, e a existência de diferentes algoritmos é justificada pelas particularidades de cada problema que eles resolvem.
