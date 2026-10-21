import { Mail, Lock, Eye, EyeOff, LogIn } from 'lucide-react';
import useLoginForm from '../hooks/useLoginForm';
import Input from '../components/Input';
import Button from '../components/Button';
import '../pages/Login.css'

export default function Login() {
  const handleLoginSuccess = (data) => {
    alert(`Login bem-sucedido para: ${data.email}!`);
  };

  const {
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
  } = useLoginForm(handleLoginSuccess);

  return (
    <div className="login-container">
      <div className="login-card">
        
        {/* Cabeçalho */}
        <div className="login-header">
          <div className="login-icon-box">
            <LogIn size={28} />
          </div>
          <h1 className="login-title">Bem-vindo de volta!</h1>
          <p className="login-subtitle">
            Entre com suas credenciais para acessar sua conta.
          </p>
        </div>

        {/* Formulário */}
        <form onSubmit={handleSubmit} className="login-form">
          {error && <div className="login-error-box">{error}</div>}

          <Input
            label="E-mail"
            id="email"
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            placeholder="seu@email.com"
            icon={Mail}
          />

          <Input
            label="Senha"
            id="password"
            type={showPassword ? 'text' : 'password'}
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder="••••••••"
            icon={Lock}
            rightElement={
              <button
                type="button"
                onClick={() => setShowPassword(!showPassword)}
                className="show-password-btn"
              >
                {showPassword ? <EyeOff size={20} /> : <Eye size={20} />}
              </button>
            }
          />

          <div className="login-options">
            <label className="checkbox-label">
              <input
                type="checkbox"
                checked={rememberMe}
                onChange={(e) => setRememberMe(e.target.checked)}
                className="checkbox-input"
              />
              <span>Lembrar-me</span>
            </label>
            <a
              href="#forgot"
              onClick={(e) => e.preventDefault()}
              className="forgot-link"
            >
              Esqueceu a senha?
            </a>
          </div>

          <Button isLoading={isLoading}>Entrar</Button>

          <p className="login-footer-text">
            Não tem uma conta?{' '}
            <a href="#signup" className="signup-link">
              Cadastre-se
            </a>
          </p>
        </form>

      </div>
    </div>
  );
}