
## Funcionalidades necessárias para aceite:

###### - Cadastro de balcões de atendimento com: 
    1. Nome do atendente do balcão 
    2. Fila de atendimento

###### - Cadastro de chamados com:
    1. Usuário (customer_id)
    2. Data do chamado
    3. Data de resolução
    4. Dados da maquininha, que precisa ter:
        1. device_id
        2. serial_number
    5. Motivo do chamado
    6. Estado do chamado, que são:
        1. ABERTO,
        2. EM_ESPERA,
        3. EM_ATENDIMENTO,
        4. CONCLUÍDO.

###### - Listar todos os chamados com paginação;
####
###### - Listar todos os chamados por customer_id com paginação;
####
###### - Mostrar detalhes de um chamado, com:
    1. Motivo do chamado
    2. Produto do chamado
    3. Usuário cliente (Integrar com data vault)
    4. Usuário atendente
    5. Data do chamado
    6. Data de resolução
    
## Regras de negócio:
###### - Enfileiramento de chamados por balcão de atendimento
    1. Ao criar um chamado, escolher um balcão que tenha
     disponibilidade (cada balcão pode ter até 5 chamados na fila)

    2. Cada chamado leva 2 minutos para ser processado
        1. Usar Job para processar os chamados
        2. Seguir ordem ABERTO > EM ESPERA > EM ATENDIMENTO > CONCLUÍDO

    3. Se as filas estiverem cheias, quando tentar criar um novo    
     chamado, este não será salvo no banco, e deverá ser colocado 
     numa fila de espera de 3 minutos

     4. Sendo processada a fila, se houver menos de 5 chamados não 
     concluídos, será salvo com status ABERTO

###### - Tratamento de conflitos
    1. Se o mesmo usuário tentar abrir um chamado para o mesmo 
     serial, deve ser retornado um conflito (Http Status 409) com a 
     url para os detalhes do chamado aberto para este item
        * Mas se o chamado do serial já tiver sido CONCLUÍDO, ele   
         pode abrir um novo chamado
         
    2. Se outro usuário tentar abrir um chamado para um serial que 
     já está em atendimento, deve ser retornado um forbidden (Http 
     Status 403) para ele
        * Mas se o chamado do serial já tiver sido CONCLUÍDO, ele 
         pode abrir um novo chamado
