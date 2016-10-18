FROM java:8

COPY hackathonCaseB.sh /
COPY data/output.csv /output/result.txt

ENV PATH $PATH:/