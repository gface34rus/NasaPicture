# NaSaPicture

NaSaPicture - это Telegram-бот, который получает изображения из NASA API и отправляет их пользователям. Пользователи могут запрашивать изображения, отправляя команды `/image` или `/date YYYY-MM-DD` в бот.

## Технологии

- Java 17
- Apache HttpComponents Client 5.4
- Jackson Databind 2.18.2
- Telegram Bots API 6.8.0
- JavaFaker 1.0.2

## Установка

1. Установите Java Development Kit (JDK) версии 17.
2. Установите Apache Maven.
3. Клонируйте репозиторий на свой компьютер:
   ```bash
   git clone <URL_репозитория>
Перейдите в директорию проекта:
COPY
cd NaSaPicture
Соберите проект с помощью Maven:
COPY
mvn clean install
Запуск
Откройте проект в вашей IDE (например, IntelliJ IDEA или Eclipse).
Запустите класс Main для старта бота.
Использование
/start - Запускает бота и предоставляет инструкции.
/help - Предоставляет информацию о доступных командах.
/image - Получает и отправляет случайное изображение из NASA.
/date YYYY-MM-DD - Получает и отправляет изображение из NASA за указанную дату.
