**Описание проекта**

Этот проект представляет собой демонстрационное Spring Boot приложение для управления доставки еды из ресторанов. Приложение использует PostgreSQL в качестве базы данных и Docker для контейнеризации.

Сущности

Restaurant (Ресторан)

id: Уникальный идентификатор ресторана.

name: Имя ресторана.

address: Адрес ресторана.

phone_number: номер телефона ресторана.

dishes: Список блюд в реторане.

P.S. name являtтся уникальным значеием в БД

Dish (Блюдо)

id: Уникальный идентификатор блюда.

restaurantId: Идентификатор ресторана блюда.

name: Название блюда.

description: Описание блюда.

price: цена за блюдо.

Логика

Приложение позволяет выполнять CRUD операции (создание, чтение, обновление, удаление) для сущностей Restaurant и Dish. Логика приложения реализована в сервисах и контроллерах.

Endpoint'ы

Restaurant Endpoints

GET /restaurants: Получить список всех ресторанов.

GET /restaurants/{id}: Получить ресторан по ID.

POST /restaurants: Создать новый ресторан.

PUT /restaurants/{id}: Обновить данные ресторана.

DELETE /restaurants/{id}: Удалить ресторан.

Dish Endpoints

GET /dishes: Получить список всех блюд.

GET /dishes/{id}: Получить блюдо по ID.

POST /dishes: Создать новое блюдо.

PUT /dishes/{id}: Обновить данные блюда.

DELETE /dishes/{id}: Удалить блюдо.

Тестирование эндпоинтов

Для тестирования эндпоинтов можно использовать коллекцию в Postman по следующей ссылке: 
https://www.postman.com/tvorog/workspace/digitalchief/collection/36573903-5b9cdc52-307b-4b0c-ada0-ace3b4bfc85e?action=share&creator=36573903

Зависимости в pom.xml

Spring Boot Starters

spring-boot-starter-data-jpa: Содержит все необходимые зависимости для работы с JPA и Hibernate, обеспечивает поддержку для работы с базой данных.
spring-boot-starter-web: Содержит все необходимые зависимости для создания веб-приложений RESTful, включая встроенный веб-сервер.
База данных

org.postgresql:postgresql: JDBC драйвер для работы с PostgreSQL базой данных.

Инструменты разработки

org.projectlombok:lombok: Библиотека для сокращения шаблонного кода в Java за счет использования аннотаций.
org.springframework.boot:spring-boot-starter-validation: Включает валидацию данных с помощью аннотаций, таких как @NotNull, @Size и т.д.
org.modelmapper:modelmapper: Библиотека для автомати ческого маппинга объектов, которая используется для преобразования DTO в сущности и обратно.
Запуск приложения

Сборка и запуск с Docker

Соберите и запустите контейнеры с помощью Docker Compose: docker-compose up --build
