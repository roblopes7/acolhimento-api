CREATE TABLE uf (
    id_uf integer,
    nome VARCHAR(200),
    sigla VARCHAR(3),
    PRIMARY KEY (id_uf)
);

CREATE TABLE cidade (
    id_cidade integer,
    nome VARCHAR(200),
    id_uf integer,
    PRIMARY KEY (id_cidade),
    CONSTRAINT fk_cidade_uf
          FOREIGN KEY(id_uf)
    	  REFERENCES uf(id_uf)
);

CREATE TABLE endereco (
    uid_endereco UUID DEFAULT uuid_generate_v4(),
    rua VARCHAR(200),
    bairro VARCHAR(200),
    numero VARCHAR(200),
    complemento VARCHAR(200),
    id_cidade integer,
    PRIMARY KEY (uid_endereco),
    CONSTRAINT fk_endereco_cidade
          FOREIGN KEY(id_cidade)
    	  REFERENCES cidade(id_cidade)
);