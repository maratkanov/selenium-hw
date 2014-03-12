selenium-hw
===========

Технопарк 2014. Тестирование. Selenium дз


Running tests on local machine
----
```
mvn clean integration-test thucydides:aggregate
```

Running tests on remote selenium driver
----
```
mvn -Dwebdriver.remote.url=[your_url] clean integration-test thucydides:aggregate
```

Example:
> mvn -Dwebdriver.remote.url=http://127.0.0.1:4444/wd/hub clean integration-test thucydides:aggregate


Просмотр отчёта о проведении тестов
----

1. Следует проследовать в директорию
> selenium-hw/target/site/thucydides
2. Открыть файл index.html