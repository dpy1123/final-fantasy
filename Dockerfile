FROM alpine

COPY hackathonCaseB.sh /
COPY data/output.csv /data/

ENV PATH $PATH:/