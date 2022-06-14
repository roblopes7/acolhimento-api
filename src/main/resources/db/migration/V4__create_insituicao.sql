CREATE TABLE instituicao (
    uid_instituicao UUID DEFAULT uuid_generate_v4(),
    nome VARCHAR(200),
    documento VARCHAR(40),
    uid_atuacao UUID,
    PRIMARY KEY (uid_instituicao),
    CONSTRAINT fk_atuacao
          FOREIGN KEY(uid_atuacao)
    	  REFERENCES atuacao(uid_atuacao)
);

CREATE TABLE instituicao_contato (
    uid_instituicao UUID,
    uid_contato UUID,
    PRIMARY KEY(uid_instituicao, uid_contato)
);
