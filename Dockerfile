FROM gradle:jdk11

RUN mkdir /usr/src/app
COPY . /usr/src/app
WORKDIR /usr/src/app
ENV REMOTE_RUN=true