<!-- PROJECT NAME -->
<h1>API - Médico Paciente 👨‍⚕️💉</h1>


<!-- DESCRIPTION -->
<h3>
    <i>API de serviços simples contendo os principais conceitos exercidos em sala de aula.</i>
</h3>


<!-- DISCIPLINE -->
<h5>DISCIPLINA: ARQUITETURA ORIENTADA A SERVIÇOS</h5>


<!-- TEACHER -->
<h5>PROFESSOR: JORGE LUÍS GREGÓRIO</h5>


<!-- AUTHORS -->
<h5>ALUNOS:</h5>
<ul>
    <li>JHENIFFER CAROLINA PEREIRA</li>
    <li>GABRIEL POSSAR SENO</li>
</ul>


<!-- HORIZONTAL LINE -->
<hr />


<!-- HOW TO SETUP THE PROJECT -->
<h3>COMO SALVAR E EXECUTAR O PROJETO:</h3>

- Na pasta onde deseja salvar o projeto, abra o `Git Bash` e clone o projeto com o comando:
```
git clone https://github.com/onesg/projetodojorge.git
```
- Abra o projeto com o `IntelliJ IDEA` e verifique se o JDK 11 está configurado corretamente.
- Dentro da pasta `src\main\resources`, certifique-se que as configurações do arquivo `application.properties` estejam corretas.
- Baixe todas as dependências necessárias do arquivo `pom.xml`.
- Abra o arquivo `ProjetodojorgeApplication.java`, use o comando `Ctrl + Shift + F10` para executar o projeto.


<!-- HORIZONTAL LINE -->
<hr />


<!-- PROJECT STATUS -->
<h6>STATUS DO PROJETO</h6>

- [x] Models;
- [x] Repositorys;
- [x] Services;
- [x] Controllers;
- [x] CRUD;
- [ ] Paginação de resultados;
- [x] HATEOAS;
- [x] Configuração CORS;
- [x] Content Negotiation (JSON, XML e YAML);
- [x] Migrations;
- [ ] Autenticação Spring Security e JWT;
- [x] Documentação com Swagger.


<!-- HORIZONTAL LINE -->
<hr />


<!-- BUG's AND FIXES -->
<h6>BUGS E CORREÇOES</h6>
<ol>
    <li>[CORRIGIDO] Implementar relação 1:N entre Médico e Paciente.</li>
    <li>[CORRIGIDO] Erro da documentação Swagger.</li>
    <li>[CORRIGIDO] Erro quando usar HATEOS e Swagger juntos.</li>
    <li>Erro na paginação de resultados com HATEOS.</li>
</ol>


<!-- HORIZONTAL LINE -->
<hr />


<!-- UTIL LINKS -->
<h6>LINKS ÚTEIS</h6>
<ul>
    <li>Setup IntelliJ IDEA</li>
    https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC
    <br><br>
    <li>Download JDK 11.0.14</li>
    https://download.oracle.com/otn-pub/java/jdk/11.0.14%2B8/7e5bbbfffe8b45e59d52a96aacab2f04/jdk-11.0.14_windows-x64_bin.exe
    <br><br>
    <li>Spring Initializr</li>
    https://start.spring.io/
    <br><br>
    <li>Maven Repository</li>
    https://mvnrepository.com/
    <br><br>
    <li>Mockaroo</li>
    https://www.mockaroo.com/
    <br><br>
    <li>Download Apache Maven</li>
    https://maven.apache.org/download.html
    <br><br>
</ul>


<!--

    //  ANOTAÇÕES

    Model
    Repository
    service
    controller

    (hibernate) usar notação: @many to one

    Vai ficar array de objetos da classe 1:N

    Exemplos 1 : N
    --------------
    Cliente Pedidos
    Curso Alunos
    Fornecedor Produtos
    Marca Produtos
    Departamento Funcionários
    Médico Pacientes
    Estado Cidades
    País Estados
    Pai/Mãe Filhos

    Médico
    id_medico
    nome
    CRM    
    especialidade
    telefone
    
    
    Paciente
    id_cliente
    nome
    idade
    telefone
    fk_id_medico
    
Links que ajudaram:
Problemas com o Swagger-ui
https://stackoverflow.com/questions/43545540/swagger-ui-no-mapping-found-for-http-request

Problemas com o HATEOS e Swagger
https://stackoverflow.com/questions/58431876/why-hateoas-starts-creating-issue-for-spring-boot-version-2-2-x-during-startu


-->
