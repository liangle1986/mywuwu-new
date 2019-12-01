FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER lianglele1986@126.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /mywuwu-oa-platform

WORKDIR /mywuwu-oa-platform

EXPOSE 5005

ADD ./mywuwu-visual/mywuwu-oa-platform/target/mywuwu-oa-platform.jar ./

CMD sleep 120;java -Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom -jar mywuwu-oa-platform.jar
