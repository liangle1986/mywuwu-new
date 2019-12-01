FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER lianglele1986@126.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /mywuwu-upms

WORKDIR /mywuwu-upms

EXPOSE 4000

ADD ./mywuwu-upms/mywuwu-upms-biz/target/mywuwu-upms-biz.jar ./

CMD sleep 120;java -Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom -jar mywuwu-upms-biz.jar
