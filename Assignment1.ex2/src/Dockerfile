# Use official OpenJDK base image (specifying version for consistency)
FROM openjdk

# Set working directory
WORKDIR /app

# Copy your Java files from the exact path
COPY Assignment1.ex2/src/ ./src/

# If you have any libraries or jars:
# COPY Assignment1.ex1/lib/ ./lib/
# COPY Assignment1.ex1/*.jar ./

# Compile (assuming no package declaration)
RUN javac src/*.java -d ./out

# Run the application
CMD ["java", "-cp", "./out", "ShoppingMain"]