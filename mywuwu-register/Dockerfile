FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER lianglele1986@126.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /mywuwu-register

WORKDIR /mywuwu-register

EXPOSE 8848

ADD ./mywuwu-register/target/mywuwu-register.jar ./


CMD sleep 60;java -Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom -jar mywuwu-register.jar


