## Next Permutation 
### Descrição 
A permutação de um array de inteiros é um arranjo de seus membros em uma sequência ou ordem linear.

Por exemplo, para arr = [1,2,3]a seguir estão todas as permutações de arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
O próxima permutação de uma matriz de inteiros é a próxima permutação lexicograficamente maior de seu inteiro. Mais formalmente, se todas as permutações da matriz são classificadas em um recipiente de acordo com sua ordem lexicográfica, então o próxima permutação dessa matriz é a permutação que a segue no contêiner classificado. Se tal arranjo não for possível, a matriz deve ser reorganizada como a ordem mais baixa possível (ou seja, ordenada em ordem crescente).

Por exemplo, a próxima permutação de arr = [1,2,3] é [1,3,2].
Da mesma forma, a próxima permutação de arr = [2,3,1] é [3,1,2].
Enquanto a próxima permutação de arr = [3,2,1] é [1,2,3] porque [3,2,1] não tem um rearranjo lexicográfico maior.
Dada uma matriz de inteiros nums encontre a próxima permutação de nums.

A substituição deve ser no lugar e use apenas memória extra constante.

 

Exemplo 1:

Entrada: nums = [1,2,3]
Saída: [1,3,2]
Exemplo 2:

Entrada: nums = [3,2,1]
Saída: [1,2,3]
Exemplo 3:

Entrada: nums = [1,1,5]
Saída: [1,5,1]

## Solução 
### Explicação
1. **Identificar o ponto de inversão**: Encontre o maior índice `i` tal que `nums[i] < nums[i + 1]`. Isso identifica onde a sequência deixa de ser crescente.
2. **Trocar elementos**: Encontre o menor elemento maior que `nums[i]` à direita de `i` e troque-os.
3. **Reverter a sequência**: Inverta a submatriz à direita de `i` para obter a próxima permutação lexicográfica.
