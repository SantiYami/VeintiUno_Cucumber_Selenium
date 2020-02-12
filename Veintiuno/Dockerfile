FROM iron/java:1.8

ADD target/ventiuno-0.0.1-SNAPSHOT.jar \
    dependency/* \
    /test/lib/

ADD src/test/resources/* \
    /test/features/

ENTRYPOINT java -ea -cp "/test/lib/*" cucumber.api.cli.Main --glue StepDefinition /test/features/

