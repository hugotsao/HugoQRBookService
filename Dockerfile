FROM openjdk:14-alpine as builder
WORKDIR /HugoQRBookService
COPY . .
RUN ./gradlew build

FROM openjdk:14-alpine
RUN addgroup -S hugo && adduser -S hugo -G hugo
USER hugo:hugo
COPY --from=builder /HugoQRBookService/build/libs/hugoqrbookservice-0.0.1-SNAPSHOT.war hugoqrbookservice-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java", "-jar", "/hugoqrbookservice-0.0.1-SNAPSHOT.war"]