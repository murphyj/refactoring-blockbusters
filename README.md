Blockbusters DOJO
================

To get started, if behind a proxy create the below file under '~/.gradle/gradle.properties'. Fill in the relevent properties.

```bash
systemProp.http.proxyHost=
systemProp.http.proxyPort=
systemProp.http.nonProxyHosts=

systemProp.https.proxyHost=
systemProp.https.proxyPort=
systemProp.https.nonProxyHosts=

systemProp.javax.net.ssl.trustStorePassword=changeit
systemProp.java.net.preferIPv4Stack=true
systemProp.socksProxyHost=
```


Once this is done:

* Go to the directory
* Type './gradlew test'


If you want to generate a IntelliJ project file:


```
./gradlew idea 
```
