# Sistema de Reservas de Hotéis

Este projeto é um sistema de reservas de hotéis desenvolvido em Java

## Funcionalidades Principais

### **Gestão de Hotéis**
- Adicionar novos hotéis com nome, endereço e descrição.
- Listar todos os hotéis cadastrados.

### **Gestão de Quartos**
- Adicionar quartos a hotéis existentes com número, tipo (Single, Couple, Premium) e preço.
- Listar todos os quartos cadastrados por hotel.

### **Gestão de Clientes**
- Criar perfis de clientes com nome, e-mail e CPF.
- Consultar pontos de fidelidade acumulados.

### **Reservas**
- Reservar quartos disponíveis informando hotel, número do quarto e CPF do cliente.
- Cancelar reservas existentes.
- Exibir relatório de reservas.

### **Avaliações**
- Permitir que clientes avaliem os hotéis após a estadia.
- Listar todas as avaliações feitas para cada hotel.

### **Relatório de Análises**
- Relatórios com dados como:
  - Hotel mais reservado
  - Quarto mais caro e mais barato
  - Hotel com melhor avaliação
  - Hotel com mais pontos de fidelidade acumulados

### **Suporte a Múltiplos Idiomas**
- Suporte completo para:
  - Português 🇧🇷
  - Inglês 🇺🇸
  - Espanhol 🇪🇸
- O idioma pode ser selecionado ao iniciar o sistema.

### **Simulação de Pagamento**
- Processamento fictício de pagamento no terminal, exibindo valores e confirmação de transação.

### **Suporte ao Cliente (Simulado)**
- Interface de suporte fictícia para dúvidas e ajuda relacionadas às reservas.
- Mensagens de interação realistas simulando um atendimento humano.

---

## Estrutura do Projeto

O projeto está dividido em pacotes organizados da seguinte forma:

- `main`: ponto de entrada da aplicação (`Main.java`)
- `manager`: classes responsáveis pela lógica do sistema (reservas, hotéis, clientes, suporte etc.)
- `model`: classes que representam as entidades (Hotel, Room, Customer, Booking etc.)
- `util`: funcionalidades auxiliares como processador de pagamento e verificação de CPF
- `i18n`: arquivos `.properties` com textos traduzidos para cada idioma

---

## Como Executar

1. **Pré-requisitos**:
   - JDK 17 ou superior instalado.

2. **Compilar o projeto**:
   No terminal, navegue até o diretório do projeto e compile:
   ```bash
   javac main/Main.java
   ```

3. **Executar o sistema**:
   ```bash
   java main.Main
   ```

4. **Selecionar o idioma**:
   Escolha entre:
   - `1` - Português
   - `2` - English
   - `3` - Español

---

## Exemplo de Uso

```text
Selecione o idioma:
1. Português
2. English
3. Español

Bem-vindo ao Sistema de Reservas de Hotéis!
1. Adicionar Hotel
2. Listar Hotéis
3. Adicionar Quarto
4. Listar Quartos
5. Criar Perfil de Cliente
6. Reservar Quarto
7. Cancelar Reserva
8. Adicionar Avaliação
9. Ver Avaliações
10. Relatório Analítico
11. Ver Pontos de Fidelidade
12. Suporte ao Cliente
13. Sair
```

---

