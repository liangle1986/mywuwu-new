FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER lianglele1986@126.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /mywuwu-gateway

WORKDIR /mywuwu-gateway

EXPOSE 9999

ADD ./mywuwu-gateway/target/mywuwu-gateway.jar ./

CMD sleep 120;java -Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom -jar mywuwu-gateway.jar
