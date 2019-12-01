FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER lianglele1986@126.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /mywuwu-sentinel-dashboard

WORKDIR /mywuwu-sentinel-dashboard

EXPOSE 5020

ADD ./mywuwu-visual/mywuwu-sentinel-dashboard/target/mywuwu-sentinel-dashboard.jar ./

CMD sleep 120;java -Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom -jar mywuwu-sentinel-dashboard.jar
