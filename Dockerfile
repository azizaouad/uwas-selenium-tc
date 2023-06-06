FROM maven:3.8.1-openjdk-17-slim as installation

RUN apt-get update -y && apt-get install zip unzip libglib2.0-0 libnss3 libxcb-randr0-dev libxcb-xtest0-dev libxcb-xinerama0-dev libxcb-shape0-dev libxcb-xkb-dev libdbus-1-dev python3-dbus libdbus-1-3 -y
RUN curl https://chromedriver.storage.googleapis.com/113.0.5672.63/chromedriver_linux64.zip -o chromedriver_linux64.zip
RUN unzip chromedriver_linux64.zip
RUN mv chromedriver /usr/bin/chromedriver
RUN curl https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb -o google-chrome-stable_current_amd64.deb
RUN apt install ./google-chrome-stable_current_amd64.deb -y

FROM installation as builder

WORKDIR /app

RUN google-chrome-stable --headless --disable-gpu --print-to-pdf https://www.chromestatus.com --no-sandbox
RUN mkdir -p /app/target
RUN touch /app/target/failedrun.txt
COPY pom.xml .
RUN mvn clean package -DskipTests
COPY . .
ENV ENVIRONMENT="recette"
ENV DRIVER="chrome"
CMD mvn clean -Denvironment="${ENVIRONMENT}" -DwebDriver="${DRIVER}" test
