# ⚡ Sistema de Gestão de Contas de Energia

Projeto desenvolvido em Java com foco na aplicação prática dos pilares e recursos de **Programação Orientada a Objetos (POO)**. O sistema permite registrar o histórico anual de consumo elétrico de um imóvel, calcular tarifas com aplicação condicional de impostos e gerar relatórios de desempenho mensal.

---

## 📋 Funcionalidades Implementadas

- **Cadastro de Contas Mensais:** Registro de leituras (anterior e atual) vinculadas a um mês de referência.
- **Cálculo de Consumo e Tarifa:**
    - Tarifa base de **R$ 0,92 por kWh**.
    - **Faixa de isenção:** Consumos inferiores a **90 kWh** pagam apenas o valor base.
    - **Tributação:** Consumos a partir de **90 kWh** recebem acréscimo de **2,5%** de taxa de iluminação pública e **22%** de ICMS (calculado sobre o valor base + iluminação).
- **Validação de Integridade:** Impede o cadastro de meses nulos, contas duplicadas para o mesmo mês e ultrapassagem do limite de 12 meses por imóvel.
- **Relatórios no Console:**
    - Relatório anual completo (mês, consumo em kWh e valor total).
    - Cálculo do valor médio anual.
    - Filtragem e exibição apenas das contas com valor acima da média anual.

---

## 🏗️ Estrutura do Projeto

O código está organizado no pacote `POO`:

- **`ContaEnergia.java`**: Representa uma fatura mensal, encapsulando as leituras, constantes tributárias, regras de cálculo de valor e comparação entre contas.
- **`Imovel.java`**: Gerencia a coleção de até 12 contas de um imóvel em um determinado ano, realizando validações de inserção, cálculo de média e emissão de relatórios.
- **`meses.java` (Enum)**: Define os meses do ano válidos para referência das faturas.
- **`App.java`**: Classe principal (`main`) responsável por instanciar os objetos, simular o ciclo de 12 meses e exibir os relatórios.

---

## 🧠 Recursos de POO Utilizados

Este projeto aplica os seguintes conceitos e recursos da linguagem Java e da Programação Orientada a Objetos:

1. **Abstração e Modelagem de Domínio**
    - Representação de entidades reais (`Imovel` e `ContaEnergia`) isolando apenas os atributos e regras de negócio relevantes para o domínio do problema.

2. **Encapsulamento e Defesa de Estado**
    - Todos os atributos das classes são declarados como `private`, impedindo modificações externas diretas.
    - O método `getContas()` da classe `Imovel` retorna uma visão somente leitura através de `Collections.unmodifiableList()`, evitando que classes externas alterem a lista interna sem passar pelas validações de `adicionarConta()`.

3. **Associação e Composição (`1:N`)**
    - A classe `Imovel` mantém uma relação de agregação/composição com `ContaEnergia` por meio de uma coleção tipada (`List<ContaEnergia>`), gerenciando o ciclo de vida do histórico anual.

4. **Atributos Estáticos e Constantes (`static final`)**
    - Uso de `private static final` em `ContaEnergia` (`ICMS`, `tarifaKWH`, `iluminacao`) para compartilhar alíquotas fixas entre todas as instâncias sem duplicar alocação de memória.

5. **Sobrescrita de Métodos (`@Override` de `equals` e `hashCode`)**
    - Implementação personalizada de `equals()` e `hashCode()` em `ContaEnergia` baseada exclusivamente no `mesReferencia`. Isso permite que o método `listaConta.contains()` identifique duplicidades lógicas (dois objetos diferentes representando o mesmo mês).

6. **Programação Defensiva e Tratamento de Exceções**
    - Uso de exceções padrão do Java (`IllegalArgumentException` e `IllegalStateException`) nos construtores e métodos para garantir que nenhum objeto entre em estado inválido (ex.: mês nulo, mês repetido ou mais de 12 contas no ano).

7. **Tipos Enumerados (`Enum`)**
    - Utilização do enum `meses` para garantir *type-safety* (segurança de tipos), evitando erros de digitação que ocorreriam caso os meses fossem tratados como `String`.

---

## 🚀 Como Executar

1. Clone o repositório:
   ```bash
   git clone [https://github.com/VictorAms12/contasDeEnergia.git](https://github.com/VictorAms12/contasDeEnergia.git)