import { useState } from "react";

export function NumberDivisible() {
    const [number, setNumber] = useState("");
    const [result, setResult] = useState("");

    const checkDivisibility = () => {
        if (parseInt(number) % 16 === 0) {
            setResult("The number is divisible by 16");
        } else {
            setResult("The number is not divisible by 16");
        }
    };

    return (
        <div>
            <h3>Check if a number is divisible by 16:</h3>
            <input
                type="number"
                value={number}
                onChange={(e) => setNumber(e.target.value)}
                placeholder="Enter a number"
            />
            <button onClick={checkDivisibility}>Check</button>
            {result && <p>{result}</p>}
        </div>
    );
}
