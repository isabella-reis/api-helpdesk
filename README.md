# Objetivo do Projeto prático
Trabalhar nas capacidades necessárias para ter mais autonomia na execução das tarefas diárias da equipe.
## Projeto: Simulador de Help Desk
### Funcionalidades
- Cadastro de balcões de atendimento
* Nome do atendente do balcão
* Fila de atendimento
- Cadastro de chamados
* Usuário (customer_id)
* Data do chamado
* Data de resolução
- Dados da maquininha
* device_id
* serial_number
- Motivo do chamado
- Estado do chamado (ABERTO, EM ESPERA, EM ATENDIMENTO, CONCLUÍDO)
- Listar todos os chamados com paginação
- Listar todos os chamados por customer_id com paginação
- Mostrar detalhes de um chamado
* Motivo do chamado
* Produto do chamado
* Usuário cliente (Integrar com data vault)
* Usuário atendente
* Data do chamado
* Data de resolução

> Ferramentas utilizadas:
> Colima + Docker + MySQL (contêiner), MySQL Workbench, Java Spring Boot 


