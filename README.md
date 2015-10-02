Dependencies
============

Most are resolved automatically with maven except the oracle ojdbc6 jar.In order to build
the project you'll need that jar installed in your local maven repo.  To install it locally run
something like:

```bash
mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file  -Dfile=path-to-your-artifact-jar \
                                                                              -DgroupId=com.oracle \
                                                                              -DartifactId=ojdbc6 \
                                                                              -Dversion=11.2.0 \
                                                                              -Dpackaging=jar \
                                                                              -DlocalRepositoryPath=path-to-specific-local-repo
```

mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file  -Dfile=/Users/jonnysamps/Downloads/instantclient_11_23/ojdbc6.jar \
                                                                              -DgroupId=com.oracle \
                                                                              -DartifactId=ojdbc6 \
                                                                              -Dversion=11.2.0 \
                                                                              -Dpackaging=jar \
                                                                              -DlocalRepositoryPath=/Users/jonnysamps/.m2
