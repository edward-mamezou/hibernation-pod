
```shell
brew install certbot
```

# 証明書の作成

```shell
$ sudo certbot certonly --manual --preferred-challenges dns
```

```shell
Please enter in your domain name(s) (comma and/or space separated)  (Enter 'c'
to cancel):
```

と聞かれるので、所有するドメイン名を入力します。そのとき、ワイルドカードを利用すると便利です。

```shell
*.example.com
```

DNS に TEXT レコードを作成する名前と値が表示されますので、DNS にレコードを追加します。

```text
_acme-challenge.example.com TXT "<設定する値>"
```

DNS への反映に若干時間がかかる場合があるので、少し待って Enter キーを押した方がいいと思います。

成功すれば、`/etc/letsencrypt/live/example.com/` 以下にファイルが作成されます。

# Private IP アドレスの DNS レコードの登録

DNS に A レコードを作成します。

```shell
internal.example.com A 192.168.1.1
```

##

- [Envoy で HTTPS 接続をする設定を学べる「Securing traffic with HTTPS and SSL/TLS」を試した](https://kakakakakku.hatenablog.com/entry/2019/12/06/143207)
