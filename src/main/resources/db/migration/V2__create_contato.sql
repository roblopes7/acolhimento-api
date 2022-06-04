CREATE TABLE contato (
    uid_contato UUID DEFAULT uuid_generate_v4(),
    telefone VARCHAR(20),
    responsavel VARCHAR(200),
    email VARCHAR(100),
    PRIMARY KEY (uid_contato)
);