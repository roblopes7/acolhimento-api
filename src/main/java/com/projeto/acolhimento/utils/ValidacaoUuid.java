package com.projeto.acolhimento.utils;

import com.projeto.acolhimento.services.exceptions.BusinessException;

import java.util.UUID;

public class ValidacaoUuid {

    private ValidacaoUuid() {
        throw new IllegalStateException("Utility class");
    }

    public static UUID validarUid(String uid) {
        try {
        if (uid == null || uid.isEmpty()) {
            throw new BusinessException("Código inválido");
        }
            return UUID.fromString(uid);
        } catch (Exception e) {
            throw new BusinessException("Código inválido");
        }
    }
}
