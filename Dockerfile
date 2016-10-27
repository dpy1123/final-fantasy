FROM java:8
WORKDIR /
COPY data/output.csv /result.txt
COPY hackathonCaseB.sh /
RUN mkdir /output/

CMD ["/bin/bash"]
RUN chmod +x /hackathonCaseB.sh
VOLUME [/output]