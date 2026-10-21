import { useState } from 'react';

/* Recebe a função onSucess como parâmetro, mantendo ele desacoplado. */
export default function useLoginForm(onSuccess) {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [rememberMe, setRememberMe] = useState(false);
    const [showPassword, setShowPassword] = useState(false);
    const [error, setError] = useState('');
    const [isLoading, setIsLoading] = useState(false);

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');

        /* Valida se todos os campos estão preenchidos */
        if (!email || !password) {
            setError('Por favor, preencha todos os campos.');
            return;
        }

        setIsLoading(true);

        try {
            /* Simulação de uma API*/
            await new Promise((resolve) => setTimeout(resolve, 1500));

            if (onSuccess) {
                onSuccess({ email, rememberMe });
            }
        } catch (err) {
            setError('E-mail ou senha inválidos. Tente novamente.');
        } finally {
            setIsLoading(false);
        }
    };

    return {
        email,
        setEmail,
        password,
        setPassword,
        rememberMe,
        setRememberMe,
        showPassword,
        setShowPassword,
        error,
        isLoading,
        handleSubmit,
    };
}

/*  
    Quando o usuário clica em entrar no Login.jsx, o formulário dispara uma função no hook (handleSubmit).    
    A função é executada aqui, e, caso dê certo, ele executa a função onSucess (handleLoginSucess no Login.jsx).
*/