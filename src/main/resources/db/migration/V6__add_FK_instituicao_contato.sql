ALTER TABLE IF EXISTS public.instituicao_contato
    ADD CONSTRAINT fk_contato FOREIGN KEY (uid_contato)
    REFERENCES public.contato (uid_contato) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE IF EXISTS public.instituicao_contato
    ADD CONSTRAINT fk_instituicao FOREIGN KEY (uid_instituicao)
    REFERENCES public.instituicao (uid_instituicao) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;