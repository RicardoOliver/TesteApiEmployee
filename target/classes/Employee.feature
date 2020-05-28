#language:pt


Funcionalidade: Teste Api  Rest  Employee  

Cenário: Adicionar Empregado 
         Dado  conjunto  Post emprega servico api do endpoint
         Quando conjunto Post faz solicitacao do  cabechalho
         Quando deve enviar o Post HTTP via request
         Então deve receber resposta valida

Cenário: Atualizar Empregado 
         Dados Conjunto Put emprega servico api endpoint
         Quando  Conjunto de Update via request Body
         E deve enviar a Put via HTTP request
         Então deve receber resposta valida do codigo via HTTP 200

Cenário: Get Empregado 
         Dado Conjunto Get de empregados do servico api endpoint
         Quando  Conjunto de solicitacao do cabecalho
         E deve enviar a solicitacao HTTP GET
         Então  deve receber resposta valida do codigo via HTTP 200

Cenário: Delete Empregado 
         Dado Conjunto  Delete empregado servico api endpoint
         Quando  Conjunto Delete Solicitacao HTTP
         Então deve receber resposta valida do codigo via HTTP 200
