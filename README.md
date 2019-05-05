### Overview 

`graal-json-decoding-issue` is a repo to help demonstrate JWT decoding issue with Graal's native image / SubstrateVM and 0auth JWT library.

### Setup Steps

  - Run `./gradlew run` to run the application and observe correct output

To observe error on native image:

  1. Run `./scripts/graal/bin/setup.sh` to setup Graal VM SDK
  1. Run `./scripts/graal/bin/dist.sh` to create uber-jar package and compile to native image under `dist/`
  1. Run `java -jar ./dist/graal-json-decoding-issue.jar` to observe correct result
  1. Run `./dist/graal-json-decoding-issue` to observe error (as below)

### Actual vs Expected Output

Expected output:

```shell
Username: famous
```

Actual output (native image):

```shell
The string '{"typ":"JWT","alg":"HS256"}' doesn't have a valid JSON format.
com.auth0.jwt.impl.JWTParser.decodeException(JWTParser.java:75)
com.auth0.jwt.impl.JWTParser.parseHeader(JWTParser.java:51)
com.auth0.jwt.JWTDecoder.<init>(JWTDecoder.java:40)
com.auth0.jwt.JWTVerifier.verify(JWTVerifier.java:369)
com.hhandoko.graaldecoding.Application.main(Application.java:19)
```
