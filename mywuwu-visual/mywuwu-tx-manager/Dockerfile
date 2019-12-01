FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER lianglele1986@126.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /mywuwu-tx-manager

WORKDIR /mywuwu-tx-manager

EXPOSE 5004
EXPOSE 9998

ADD ./mywuwu-visual/mywuwu-tx-manager/target/mywuwu-tx-manager.jar ./

CMD sleep 120;java -Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom -jar mywuwu-tx-manager.jar
