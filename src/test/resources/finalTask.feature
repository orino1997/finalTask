#language: ru

Функционал: Добавление в корзину
  Структура сценария:
    * Перейти на сервис "https://www.ozon.ru/"
    * Закрыть всплывающее окно рекламы, если оно появилось
    * Выполнить поиск по
      |<товар>|
    * Ограничить "Цена" до
      |<цена>|
    * Отметить чекбокс "Высокий рейтинг"
    * Отметить чекбокс "3 ГБ"
    * Добавить в корзину "нечетные" товары в количестве "5"
    * Перейти в корзину и проверить, что количество товаров соответствует ранее переданному
    * Проверить, что в корзине лежат добавленные ранее товары
    * Удалить все товары из корзины
    * Проверить, что корзина пуста
    * Добавить файл с информацией о всех добавленных товарах, самом дорогом товаре в отчет
    Примеры:
      |товар | |цена |
      |iphone | |100000|

  Структура сценария:
    * Перейти на сервис "https://www.ozon.ru/"
    * Закрыть всплывающее окно рекламы, если оно появилось
    * Выполнить поиск по
      |<товар>|
    * Ограничить "Цена" до
      |<цена>|
    * Выбрать следующие "Бренды": "Beats", "Samsung"
    * Отметить чекбокс "Высокий рейтинг"
    * Добавить в корзину "четные" товары в количестве "все"
    * Перейти в корзину и проверить, что количество товаров соответствует ранее переданному
    * Удалить все товары из корзины
    * Проверить, что корзина пуста
    * Добавить файл с информацией о всех добавленных товарах, самом дорогом товаре в отчет
    Примеры:
      |товар                 | |цена  |
      |беспроводные наушники | |10000 |