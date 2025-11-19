### Meeting Rooms III
## Descrição do Desafio 
Você recebe um número inteiro n. Há n quartos numerados de 0 para n - 1.

Você recebe uma matriz inteira 2 D meetings onde significa que uma reunião será realizada durante o meio fechado intervalo de tempo . Todos os valores de são único.meetings[i] = [starti, endi][starti, endi)starti

As reuniões são alocadas nas salas da seguinte forma:

Cada reunião acontecerá na sala não utilizada com o mais baixo número.
Se não houver salas disponíveis, a reunião será adiada até que uma sala fique livre. A reunião atrasada deverá ter o mesmo duração da reunião original.
Quando uma sala fica sem uso, reuniões que têm um original anterior começar deve ser dado tempo ao quarto.
Retorno o número da sala que mais reuniões realizou. Se houver vários quartos, volte o quarto com o mais baixo número.

A intervalo semicerrado [a, b) é o intervalo entre a e b incluindo a e não incluindo b.

 

Exemplo 1:

Entrada: n = 2, reuniões = [[0,10],[1,5],[2,7],[3,4]]
Saída: 0
Explicação:
- No momento 0, ambos os quartos não estão sendo usados. A primeira reunião começa na sala 0.
- No momento 1, apenas a sala 1 não está sendo usada. A segunda reunião começa na sala 1.
- No momento 2, ambos os quartos estão sendo usados. A terceira reunião está atrasada.
- No momento 3, ambos os quartos estão sendo usados. A quarta reunião está atrasada.
- No tempo 5 termina a reunião na sala 1. A terceira reunião começa na sala 1 para o período [5,10).
- No tempo 10, terminam as reuniões em ambas as salas. A quarta reunião começa na sala 0 para o período [10,11).
Ambas as salas 0 e 1 realizaram 2 reuniões, então retornamos 0. 
Exemplo 2:

Entrada: n = 3, reuniões = [[1,20],[2,10],[3,5],[4,9],[6,8]]
Saída: 1
Explicação:
- No momento 1, todos os três quartos não estão sendo usados. A primeira reunião começa na sala 0.
- No momento 2, os quartos 1 e 2 não estão sendo usados. A segunda reunião começa na sala 1.
- No tempo 3, apenas a sala 2 não está sendo usada. A terceira reunião começa na sala 2.
- No horário 4, todos os três quartos estão sendo usados. A quarta reunião está atrasada.
- No tempo 5 termina a reunião na sala 2. A quarta reunião começa na sala 2 para o período [5,10).
- No horário 6, todos os três quartos estão sendo usados. A quinta reunião está atrasada.
- No tempo 10 terminam as reuniões nas salas 1 e 2. A quinta reunião começa na sala 1 para o período [10,12).
A sala 0 realizou 1 reunião, enquanto as salas 1 e 2 realizaram 2 reuniões cada, então retornamos 1. 
 
