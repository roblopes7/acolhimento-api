ALTER TABLE IF EXISTS public.instituicao
    ADD COLUMN uid_endereco uuid;

ALTER TABLE IF EXISTS public.instituicao
    ADD CONSTRAINT fk_instituicao_endereco FOREIGN KEY (uid_endereco)
    REFERENCES public.endereco (uid_endereco)
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;