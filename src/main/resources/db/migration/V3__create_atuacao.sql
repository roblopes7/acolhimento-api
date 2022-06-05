CREATE TABLE atuacao (
    uid_atuacao UUID DEFAULT uuid_generate_v4(),
    descricao VARCHAR(100),
    PRIMARY KEY (uid_atuacao)
);