# play-clean-java

Clean Architecture sample in PlayFramework

参考記事は以下です  
https://nrslib.com/clean-architecture/  

## 機能
アプリケーションの機能は次のとおりです。

* ユーザ CRUD
* ログインとログイン情報確認

# Config

## application.conf

```
# My project config:
# project.di = "product"
project.di = "debug"
```

設定のコメントアウトを変更することでプロダクトモードとデバッグモードが切り替わります。  
  
* "debug": DebugDependencyConfig が利用されます。  
* "product": ProductDependencyConfig が利用されます。  
