# Usando uma imagem base compatível com Java 23
FROM eclipse-temurin:23-jdk

# Definindo o diretório de trabalho dentro do container
WORKDIR /app

# Copiando o arquivo JAR da aplicação para o container
COPY target/user_service-0.0.1-SNAPSHOT.jar  app.jar

# Expondo a porta da aplicação (ajuste se necessário)
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
