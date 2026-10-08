import './Button.css'

export default function Button({ children, isLoading, type = 'submit', ...props }) {
  return (
    //
    <button type={type} disabled={isLoading} className="btn" {...props}>
      {isLoading ? <div className="spinner" /> : children}
    </button>
  );
}

/*
    children: tudo o que se tem dentro do componente Button.
    isLoading: variável do tipo boolean que mostra se está carregando ou não.
    type = 'submit': tipo padrão do botão HTML.
    O operador rest/spread pega qualquer outra propriedade extra que você passar para o botão e joga direto no elemento HTML final.
 */