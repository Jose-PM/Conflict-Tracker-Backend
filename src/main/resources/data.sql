-- =========================
-- PAÍSES
-- =========================
INSERT INTO countries (name, code) VALUES
('Ucrania', 'UKR'),
('Rusia', 'RUS'),
('Estados Unidos', 'USA'),
('Francia', 'FRA');

-- =========================
-- CONFLICTOS
-- =========================
INSERT INTO conflicts (name, start_date, status, description) VALUES
('Conflicto en Ucrania', '2022-02-24', 'ACTIVE', 'Conflicto armado en Ucrania iniciado en 2022'),
('Guerra Civil Ejemplo', '2019-01-01', 'ENDED', 'Ejemplo de conflicto finalizado');

-- =========================
-- RELACIÓN CONFLICTO - PAÍS
-- (ManyToMany)
-- =========================
-- Conflicto 1: Ucrania y Rusia
INSERT INTO conflict_countries (conflict_id, country_id) VALUES
(1, 1),
(1, 2);

-- Conflicto 2: EEUU y Francia
INSERT INTO conflict_countries (conflict_id, country_id) VALUES
(2, 3),
(2, 4);

-- =========================
-- FACCIONES
-- =========================
INSERT INTO factions (name, conflict_id) VALUES
('Facción A', 1),
('Facción B', 1),
('Facción C', 2);

-- =========================
-- RELACIÓN FACCION - PAÍS
-- =========================
INSERT INTO faction_supporting_countries (faction_id, country_id) VALUES
(1, 3), -- EEUU apoya Facción A
(2, 2), -- Rusia apoya Facción B
(3, 4); -- Francia apoya Facción C

-- =========================
-- EVENTOS
-- =========================
INSERT INTO events (event_date, location, description, conflict_id) VALUES
('2022-03-01', 'Kiev', 'Primer ataque importante', 1),
('2022-03-15', 'Mariupol', 'Asedio de la ciudad', 1),
('2019-02-01', 'Ciudad Ejemplo', 'Inicio de operaciones', 2);
