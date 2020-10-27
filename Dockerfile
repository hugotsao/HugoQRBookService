FROM gradle:jdk14 as builder
RUN useradd -ms /bin/bash hugo
WORKDIR /home/hugo/HugoQRBookService
COPY . .
RUN gradle build

FROM openjdk:14-alpine
RUN addgroup -S hugo && adduser -S hugo -G hugo
WORKDIR /home/hugo
USER hugo
COPY --from=builder /home/hugo/HugoQRBookService/build/libs/hugoqrbookservice-0.0.1-SNAPSHOT.war hugoqrbookservice-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java", "-jar", "/home/hugo/hugoqrbookservice-0.0.1-SNAPSHOT.war"]