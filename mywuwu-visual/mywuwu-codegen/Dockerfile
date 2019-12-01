FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER lianglele1986@126.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /mywuwu-codegen

WORKDIR /mywuwu-codegen

EXPOSE 5003

ADD ./mywuwu-visual/mywuwu-codegen/target/mywuwu-codegen.jar ./

CMD sleep 120;java -Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom -jar mywuwu-codegen.jar
