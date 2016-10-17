FROM java:8

COPY hackathonCaseB.sh /
COPY data/output.csv /data/

ENV PATH $PATH:/