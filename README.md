# Animal Adoption API
## Pré-requisitos
Você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[JDK](https://www.oracle.com/br/java/technologies/downloads/), [Maven](https://maven.apache.org/download.cgi).
### Configurar as variáveis de ambiente Maven
Adicionar na variável de ambiente "Path" o caminho para a pasta "bin" do maven;
### Configurar as variáveis de ambiente para o Java (Caso não exista um JDK configurado na máquina)
Adicionar na variável de ambiente "JAVA_HOME" o caminho para a pasta onde o JDK foi descompactado;


## Executando o projeto

### Baixe um zip ou clone o repositório
git clone [https://github.com/deywidfarias/animal-adoption-api.git](https://github.com/deywidfarias/animal-adoption-api.git)

### Acesse a pasta do projeto no terminal/cmd
cd animal-adoption-page

### Empacotar projeto e gerar executável
mvn package

### Acessar a pasta onde foi gerado o executável
cd target

### Executar o arquivo .jar gerado pelo maven ou execute o arquivo
java -jar AnimalAdoption-0.0.1-SNAPSHOT.jar

### O servidor inciará na porta:8080 - acesse <http://localhost:8080>
