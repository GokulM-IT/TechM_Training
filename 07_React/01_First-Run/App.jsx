const { useState } = React;
// import { useState } from "react"; it won't work here

function App() {
    const [name, setName] = useState('John');

    return (
        <div onClick={() => setName("Kat")}>{name}</div>
    );
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);
