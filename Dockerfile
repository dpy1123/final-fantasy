FROM java:8
WORKDIR /
COPY data/output.csv /result.txt
COPY hackathonCaseB.sh /
CMD ["/bin/bash"]
RUN chmod +x /hackathonCaseB.sh
VOLUME [/output]