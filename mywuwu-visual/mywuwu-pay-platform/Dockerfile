FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER lianglele1986@126.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /mywuwu-pay-platform

WORKDIR /mywuwu-pay-platform

EXPOSE 5010

ADD ./mywuwu-visual/mywuwu-pay-platform/target/mywuwu-pay-platform.jar ./

CMD sleep 120;java -Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom -jar mywuwu-pay-platform.jar
