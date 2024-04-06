<?php

class PasswordHasher {
    public function hashPassword($senha) {
        // Criar o hash da senha usando PASSWORD_DEFAULT
        return password_hash($senha, PASSWORD_DEFAULT);
    }

    public function verificarSenha($senha, $hash) {
        // Verificar se a senha corresponde ao hash
        return password_verify($senha, $hash);
    }
}

// Exemplo de uso
$passwordHasher = new PasswordHasher();

// Solicitar que o usuário insira a senha
echo "Insira a senha: ";
$senha = trim(fgets(STDIN));

// Criar o hash da senha
$hash = $passwordHasher->hashPassword($senha);

// Imprimir o hash
echo "Hash da senha: $hash\n";

// Solicitar que o usuário insira a senha para verificação
echo "Insira a senha novamente para verificação: ";
$senhaVerificacao = trim(fgets(STDIN));

// Verificar se a senha corresponde ao hash
if ($passwordHasher->verificarSenha($senhaVerificacao, $hash)) {
    echo "Senha correta!\n";
} else {
    echo "Senha incorreta!\n";
}
?>
