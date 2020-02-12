FROM iron/java:1.8

ADD target/ventiuno-0.0.1-SNAPSHOT.jar \
    target/dependency/* \
    /test/lib/

ADD src/test/resources/* \
    features

ADD src/test/java/ventiuno/ventiuno* \
    steps

ENTRYPOINT java -cp "/test/lib/*" cucumber.api.cli.Main --glue steps features

