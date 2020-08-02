-- Init data
INSERT INTO dits_test.role (name) VALUES ('ADMIN'), ('USER'), ('TUTOR');

INSERT INTO dits_test.user (first_name, middle_name, last_name, login, password, email, is_enabled) VALUES
('Q', 'Q', 'Q', 'Q', '$2y$12$OhoYMgRyThvzxCt5IjecYeU.cMxwOs2CQpylcPiSsg0EGnAqt34k6', 'aleksandr.anashkevich@gmail.com', 1);

INSERT INTO dits_test.user_role (user_id, role_id) VALUES
(1, 1), (2, 2), (3, 3), (1, 2), (3, 1), (3, 2), (4, 1);

INSERT INTO dits_test.topic (description, name) VALUES
('Исключение и ошибки. Checked и Unchecked исключение. Проверка исключений.','Исключения'),
('Примитивные типы. Группы примитивов. Особенности.','Примитивные типы'),
('Класс String. Классы StringBuilder и StringBuffer. Методы класса.','Строки'),
('Ссылочные типы. Оссобенности. Класс Object.','Ссылочные типы'),
('ООП. Инкапсуляция. Наследование. Полиморфизм.','ООП');