FROM openjdk

WORKDIR /app

COPY Assignment1.ex3/src/ ./src/

RUN javac src/*.java -d ./out

CMD ["java", "-cp", "./out", "InsuranceMain"]