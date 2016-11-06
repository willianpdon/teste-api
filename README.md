# TESTE - API
	Serviço rest para realizar compras de produtos.


# Tecnologias Necessarias
	Requisitos basicos para o sistema operacional.

 - JDK 1.7
 - Eclipse IDE
 - PostgreSql
 - Maven
 - Git
 - Apache Tomcat 7
  
# Configuração do Ambiente
  
 - Fazer o clone do projeto no Github na URL https://github.com/willianpdon/teste-api.git
 
 - Importar projeto no Eclipse IDE
 
 - Adicionar o Apache Tomcat 7 no Eclipse IDE 
 
 - Adicionar o projeto teste-api no tomcat
 
# Configuração do Banco de Dados
 - Criar usuario user = postgres
 - Criar senha password = postgres
 - Criar uma DataBases chamado sciensa 
 - Criar uma Schema  chamado sciensa
 
 
Depois de todo esse procedimento para configuração do ambiente, pode começar testar os serviços. 
 	
Para acessar a modelagem da API basta acessar a URL http://localhost:8080/teste-api/swagger-ui.html

Para realizar uma compra primeiro deve ser inserido um produdo através do endpoint http://localhost:8080/teste-api/produto/salvar, depois pode efetuar uma compra pelo endpoint http://localhost:8080/teste-api/compra/salvar.

Não foi criado nenhuma interface para testar os serviços, mas pode ser testado através da ferramenta POSTMAN do google chrome, basta fazer o download através do link https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop, assim que abrir o POSTMAN segue o passo a passo:


- Fazer download do arquivo dentro do projeto URL: https://github.com/willianpdon/teste-api/blob/master/arquivos/teste-api-collections.json
- Importar o arquivo (COLLECTIONS) no POSTMAN.
- Depois desses procedimentos, seu POSTMAN já estará com todas as chamadas da API para começar os testes.


#Modelo Banco de Dados


![A photo of the Metamaquina2Beta 3d printer](https://github.com/willianpdon/teste-api/blob/master/arquivos/MODELO_BANCO_DADOS.png?raw=true)






 	 
 
 
  