FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER lianglele1986@126.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /mywuwu-daemon-elastic-job

WORKDIR /mywuwu-daemon-elastic-job

EXPOSE 5002

ADD ./mywuwu-visual/mywuwu-daemon-elastic-job/target/mywuwu-daemon-elastic-job.jar ./

CMD sleep 120;java -Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom -jar mywuwu-daemon-elastic-job.jar
