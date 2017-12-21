# alfresco-community-validator
My Personal Validator of Alfresco Community Edition

## How can I use it ?

a) install Alfresco Community Edition using https://github.com/paulbrodner/alfresco-community-deployment

b) download the jar tests executable from releases
```bash
$ wget https://github.com/paulbrodner/alfresco-community-validator/releases/download/5.2.N-0.0.1/alfresco-community-validator-5.2.N-0.0.1-all-tests.jar
```

c) run tests

```bash
$ java -jar alfresco-community-validator-5.2.N-0.0.1-all-tests.jar
```

This will automatically run some smoke tests on your local installation of Alfreso Community Edition. 
Currently the server name is harcoded to `http://localhost:8080`
