import { useState } from "react";

export function AvailableCards() {
    const [aadhar, setAadhar] = useState(false);
    const [pan, setPan] = useState(false);
    const [result, setResult] = useState("")

    const checkCards = () => {
        if (aadhar || pan) {
            setResult("The user is eligible for the government offer.");
        } else {
            setResult("The user is not eligible for the government offer.");
        }
    };

    return (
        <div>
            <h3>Check available cards for government offer:</h3>
            <label>
                Has Aadhar Card?
                <input
                    type="checkbox"
                    checked={aadhar}
                    onChange={() => setAadhar(!aadhar)}
                />
            </label>
            <label>
                Has PAN Card?
                <input
                    type="checkbox"
                    checked={pan}
                    onChange={() => setPan(!pan)}
                />
            </label>
            <button onClick={checkCards}>Check Eligibility</button>
            <h4>{result}</h4>
        </div>
    );
}
