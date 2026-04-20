# Trabalho Final POO SERRATEC
Projeto desenvolvido como trabalho final individual da disciplina de Programação Orientada a Objetos, na residência SERRATEC, com foco na aplicação prática dos principais conceitos da linguagem Java.

Trabalho feito por <a  href="https://github.com/lcamaraol/">Bernardo da Silva Araújo de Oliveira. </a>


---

### 📖 Exercício 01: Simulador de Caixa Eletrônico

<details>
<summary>🔽 Clique para expandir a questão</summary>

#### 1 - Lógica e Estruturas de Controle

**Exercício:** Simulador de Caixa Eletrônico (Apenas lógica no `main`).

**Detalhes:**  
Criar um menu utilizando `do-while` e `switch` com as seguintes opções:

- 1 - Ver Saldo  
- 2 - Depositar  
- 3 - Sacar  
- 0 - Sair  

**Regras de Negócio:**

- O caixa eletrônico tem um limite máximo de 3 saques diários. Se o usuário tentar um 4º saque, o sistema deve bloquear a operação informando "Limite de saques diários
atingido.
- O valor máximo por saque é de R$ 1.000,00, por questões de segurança.

</details>

### 📖 Exercício 02: Criando a classe ContaBancaria


<details>
<summary>🔽 Clique para expandir a questão</summary>

#### 2 - Classes e Objetos

**Exercício:** Criando a classe ContaBancaria.

**Detalhes:**  
Migrar a lógica do exercício anterior para uma estrutura de **Programação Orientada a Objetos**.  
Criar a classe com os atributos `numero`, `titular` e `saldo`, e os métodos `depositar()` e `sacar()`.  
A classe deve ser instanciada no `main`.

**Regras de Negócio:**

- Todas as regras do exercício anterior devem ser seguidas.  
- Toda conta nova deve receber um **bônus de boas-vindas de R$ 50,00**, garantido no momento da criação do objeto (construtor).

</details>

### 📖 Exercício 03: - E-commerce

<details>
<summary>🔽 Clique para expandir a questão</summary>

#### 3 - Relacionamentos e Encapsulamento

**Exercício:** E-commerce (Cliente -> Pedido -> ItemPedido).

**Detalhes:**  
Modelar um Pedido que pertence a um Cliente e contém uma Lista de ItemPedido.

**Regra de Negócio:**

- Calcular o Frete: Criar um método fecharPedido(). Se o valor total dos itens for superior a R$250,00, o frete é grátis. Caso contrário, cobrar uma taxa fixa de R$25,00. Imprimir o recibo detalhado.

</details>

### 📖 Exercício 04: Sistema de Veículos

<details>
<summary>🔽 Clique para expandir a questão</summary>

#### 4 - Um cadinho de tudo

**Exercício:** Sistema de Veículos.

**Detalhes:**

- Criar interface Fretavel com metodo alugarVeiculo(pesoCarga, dias);
- Criar interface Tributavel com metodo calcularIpva();
- Criar classe mãe abstract sealed Veiculo (final placa, final marca, valorLocacaoDiaria,  final anoFabricacao, precoFipe) implementa Fretavel e Tributavel.  
- Criar classe filha Caminhao (final capacidadeCargaToneladas).  
- Criar classe filha CarroPasseio.  

**Regra de Negócio:**

- Ao calcular o valor da locação através do método alugarVeiculo(pesoCarga, dias), caso o peso da carga informado seja maior que a capacidade máxima do caminhão, deverá ser aplicado um acréscimo de 10% sobre o valor total das diárias como taxa de sobrecarga.  

- Regra do Governo: Veículos com mais de 20 anos de fabricação são isentos de IPVA (retornam 0.0). Se for mais novo, o CarroPasseio paga 4% do valor de tabela e o Caminhao paga 1.5%.  

- Deverá ser tratada exceções para criação dos objetos(construtores) e exceções nas chamadas dos metodos, qualquer parametro inválido deve ser lançada uma exeção e tratada no metodo main  

</details>

## 🛠️ Tecnologias Utilizadas

- Java
- VS Code