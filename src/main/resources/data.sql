CREATE TABLE IF NOT EXISTS contacorrente
(id_cc INT AUTO_INCREMENT PRIMARY KEY,
conta_id INT,
saldo DECIMAL,
cliente_id INT,
CONSTRAINT uc_contacorrente UNIQUE (conta_id)
);

INSERT IGNORE INTO contacorrente(conta_id, saldo, cliente_id) VALUES (1500603806, 1000.00, 123);
INSERT IGNORE INTO contacorrente(conta_id, saldo, cliente_id) VALUES (1500555555, 5000.00, 321);