FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER lianglele1986@126.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /mywuwu-daemon-quartz

WORKDIR /mywuwu-daemon-quartz

EXPOSE 5007

ADD ./mywuwu-visual/mywuwu-daemon-quartz/target/mywuwu-daemon-quartz.jar ./

CMD sleep 120;java -Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom -jar mywuwu-daemon-quartz.jar
