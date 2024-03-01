INSERT INTO client (name) VALUES
('Peter'),
('John'),
('Ivan'),
('Andrey'),
('George'),
('Eugene'),
('Gabriel'),
('Ann'),
('Victor'),
('Daniel');
INSERT INTO planet (id, name) VALUES
('MAR', 'Mars'),
('NEP', 'Neptune'),
('EAR', 'Earth'),
('JUP', 'Jupiter'),
('SAT', 'Saturn');
INSERT INTO ticket (client_id, from_planet_id, to_planet_id) VALUES
(1, 'MAR', 'EAR'),
(2, 'NEP', 'MAR'),
(3, 'EAR', 'JUP'),
(4, 'MAR', 'SAT'),
(5, 'EAR', 'NEP'),
(6, 'JUP', 'MAR'),
(7, 'SAT', 'EAR'),
(8, 'MAR', 'NEP'),
(9, 'NEP', 'SAT'),
(10, 'JUP', 'EAR');