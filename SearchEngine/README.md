<h1>Search Engine</h1>

<h3> Описание </h3>
Поисковый движок по указанным сайтам, представляющий собой Spring-приложение.


<h3> Используемые технологии:</h3>
<ul>
  <li> Spring</li>
  <li> SQL</li>
  <li> JSOUP</li>
  <li> Morphology Library Lucene</li>
  <li> Maven</li>
</ul>



<h3> Запуск проект: </h3>
Настройте Application.yaml, указав свои логин и пароль.

application.yaml:
```yaml
spring:
  datasource:
    username: LOGIN
    password: PASSWORD
    url: jdbc:mysql://localhost:3306/search_engine?useSSL=false&requireSSL=false&allowPublicKeyRetrieval=true
```

Веб-интерфейс: http://localhost:8080/