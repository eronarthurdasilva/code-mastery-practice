## Solução de Distância de Edição em Java

Este repositório contém uma solução em Java para o problema de Distância de Edição, também conhecido como problema de distância de Levenshtein. O problema de Distância de Edição é um problema algorítmico clássico que mede o número mínimo de operações necessárias para converter uma string em outra.

## Começando

Para começar com este projeto, você precisará ter Java e Visual Studio Code instalados em sua máquina. Siga as instruções abaixo para configurar seu ambiente de desenvolvimento.

### Pré-requisitos

- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (versão 11 ou superior)
- [Visual Studio Code](https://code.visualstudio.com/)

### Instalação

1. Clone o repositório:
    ```sh
    git clone https://github.com/seu-usuario/seu-repositorio.git
    ```
2. Abra o projeto no Visual Studio Code:
    ```sh
    code seu-repositorio
    ```

## Estrutura de Pastas

O espaço de trabalho contém as seguintes pastas:

- [src](http://_vscodecontentref_/1): Contém o código-fonte da solução de Distância de Edição.
- [lib](http://_vscodecontentref_/2): Contém quaisquer dependências necessárias para o projeto.

Os arquivos de saída compilados serão gerados na pasta [bin](http://_vscodecontentref_/3) por padrão.

> Se você quiser personalizar a estrutura de pastas, abra [settings.json](http://_vscodecontentref_/4) e atualize as configurações relacionadas lá.

## Executando a Solução

Para executar a solução, abra o projeto no Visual Studio Code e execute a classe principal na pasta [src](http://_vscodecontentref_/5). Você pode usar o terminal integrado ou os recursos de execução/depuração do Visual Studio Code.

### Passos para Executar

1. Compile o código:
    ```sh
    javac -d bin src/*.java
    ```
2. Execute o programa:
    ```sh
    java -cp bin MainClass
    ```

## Gerenciamento de Dependências

A visualização `JAVA PROJECTS` no Visual Studio Code permite gerenciar suas dependências. Mais detalhes podem ser encontrados [aqui](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Explicação do Código

A solução usa programação dinâmica para calcular a distância de edição entre duas strings. Os principais passos envolvidos são:

1. **Inicialização**: Crie um array 2D para armazenar as distâncias.
2. **Preenchimento do Array**: Use loops aninhados para preencher o array com base nas operações mínimas necessárias.
3. **Resultado**: O valor na célula inferior direita do array representa a distância de edição.

Para uma explicação detalhada do algoritmo, consulte os comentários no código-fonte.

### Exemplo de Código

```java
// filepath: /src/EditDistance.java
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[m][n];
    }
}
