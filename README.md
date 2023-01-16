Hibernation Pod
===

## 準備

```shell
cp src/test/resources/james.wav /tmp/james.wav
```

## Hello

- podId: id-001
- helloVoice: file:///tmp/james.wav

```shell
mosquitto_pub -t hibernation-pod/hello -m '{"eventId": "6a2e2a34-e9a4-11ec-a6d0-5b3ca1b7fd1a", "podId": "id-001", "helloVoice": "file:///tmp/james.wav", "time": "20220612000000"}' 
```

## Keycloak

```shell
docker run -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=password -p 8080:8080 jboss/keycloak
```

## Reference

- [Trilarion / java-vorbis-support](https://github.com/Trilarion/java-vorbis-support)
- [SPRING BOOT](https://camel.apache.org/camel-spring-boot/3.17.x/spring-boot.html)
- [WebAuthn でパスワードの無い世界へ](https://developer.mamezou-tech.com/blogs/2022/06/15/webauthn-1/)
- [Spring Boot と Apache Camel の統合](https://developer.mamezou-tech.com/blogs/2022/06/12/spring-boot-with-apache-camel-integration/)
