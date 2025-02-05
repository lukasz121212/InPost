# Use Maven official image for building the project
FROM maven:3.9.2-eclipse-temurin-17 as builder

# Set working directory
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the project and build it
COPY . .
RUN mvn clean package -DskipTests

# Use JDK runtime for execution
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy compiled JARs from builder stage
COPY --from=builder /app/target /app/target

# Entry point for running tests
ENTRYPOINT ["sh", "-c"]
CMD ["echo 'Specify test type (gui, api, all) as argument' && exit 1"]