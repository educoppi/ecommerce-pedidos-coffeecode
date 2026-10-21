import '../components/Input.css'

export default function Input({
  label,
  id,
  type = 'text',
  value,
  onChange,
  placeholder,
  icon: Icon,
  rightElement,
  error,
}) {
  return (
    <div className="input-wrapper">
      <label htmlFor={id} className="input-label">
        {label}
      </label>
      <div className="input-container">
        {Icon && (
          <span className="input-icon">
            <Icon size={20} />
          </span>
        )}
        <input
          id={id}
          type={type}
          value={value}
          onChange={onChange}
          placeholder={placeholder}
          className={`input-field ${Icon ? 'has-icon' : ''} ${
            rightElement ? 'has-right-element' : ''
          } ${error ? 'error' : ''}`}
        />
        {rightElement && <span className="input-right-element">{rightElement}</span>}
      </div>
    </div>
  );
}