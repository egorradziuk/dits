-- Init data
INSERT INTO dits_test.role (name) VALUES ('ADMIN'), ('USER'), ('TUTOR');

INSERT INTO dits_test.user (first_name, middle_name, last_name, login, password, email, is_enabled) VALUES
('Alexandr', 'Alexandrovich', 'Heilash', 'Alexandr_H', '$2a$10$vDSVH5faQY74UeV.7RIKyuq08dOSwOPrmDKf1Tpw2Oj6dhCiWuo0q', 'alexandr.heilash@gmail.com', 1),
('Yahor', 'Sergeevich', 'Radziuk', 'Yahor_R', '$2y$12$QSb8i3iKaogmp/yDIQNygO.aagyFJGDhwKcWQz5Yq8m55ZVXDypUW', 'yahor.radziuk@gmail.com', 0),
('Aleksandr', 'Dmitrievich', 'Anashkevich', 'Aleksandr_A', '$2y$12$UP9MTW3Xk8a64vBJ7XCQP.R3RpED/.L/5gRppS0tpib8KC93SofUe', 'aleksandr.anashkevich@gmail.com', 1),
('Q', 'Q', 'Q', 'Q', '$2y$12$OhoYMgRyThvzxCt5IjecYeU.cMxwOs2CQpylcPiSsg0EGnAqt34k6', 'aleksandr.anashkevich@gmail.com', 1);

INSERT INTO dits_test.user_role (user_id, role_id) VALUES
(1, 1), (2, 2), (3, 3), (1, 2), (3, 1), (3, 2), (4, 1);

INSERT INTO dits_test.topic (description, name) VALUES
('Исключение и ошибки. Checked и Unchecked исключение. Проверка исключений.','Исключения'),
('Примитивные типы. Группы примитивов. Особенности.','Примитивные типы'),
('Класс String. Классы StringBuilder и StringBuffer. Методы класса.','Строки'),
('Ссылочные типы. Оссобенности. Класс Object.','Ссылочные типы'),
('ООП. Инкапсуляция. Наследование. Полиморфизм.','ООП');
