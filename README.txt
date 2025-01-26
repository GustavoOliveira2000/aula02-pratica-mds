# Projeto: Hotel Management System

## Descrição Geral
Este projeto implementa um sistema de gestão de hotel utilizando Java. O sistema é baseado em uma arquitetura modular, com menus separados para **Gerentes**, **Funcionários** e **Hóspedes**, permitindo operações específicas para cada tipo de usuário.

## Estrutura do Sistema
- **Classe Hotelmanagement**: Classe principal que gerencia o fluxo do sistema com menus para Gerente, Funcionário e Hóspede.
- **Classes Fundamentais**:
  - `Quarto`: Gerencia informações e operações relacionadas aos quartos.
  - `Manutencao`: Gerencia os dados e status de manutenções associadas aos quartos.
  - `Reserva`: Permite gerenciar reservas realizadas pelos hóspedes.
  - `Funcionarios` e `Hospedes`: Representam os usuários do sistema.

## Decisões Tomadas
1. **Menus Separados**:
   - **Gerente**: Acesso a métodos de manipulação de quartos e manutenções, além de confirmar ou rejeitar reservas.
   - **Funcionário**: Acesso restrito a métodos de manutenções e reservas.
   - **Hóspede**: Pode apenas criar reservas.

2. **Persistência Simples**:
   - Utilização de listas estáticas em cada classe (`Quarto`, `Manutencao` e `Reserva`) para armazenar dados em memória.

3. **Modularidade**:
   - Métodos como `criarQuarto`, `editarQuarto`, `registrarManutencao` e `criarReserva` foram implementados para centralizar operações e evitar duplicação de código.

4. **Entrada via Command Line**:
   - Todos os menus e operações são interativos e baseados em entradas do usuário via `Scanner`.

5. **Testes com Dados de Exemplo**:
   - Foram criados três quartos e duas reservas para testar o sistema.

## Como Testar
1. **Executar o Programa**:
   - O sistema inicia solicitando o tipo de usuário: Gerente, Funcionário ou Hóspede.
2. **Utilizar os Menus**:
   - Gerente: Gerenciar quartos, manutenções e reservas.
   - Funcionário: Registrar/verificar manutenções e confirmar/rejeitar reservas.
   - Hóspede: Criar uma nova reserva.


