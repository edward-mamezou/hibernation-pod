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
