const VowelChecker = () => {
    const inputString = "Hello World";
    const vowels = ['a', 'e', 'i', 'o', 'u'];

    const checkVowels = (str) => {
        for (let char of str.toLowerCase()) {
            if (vowels.includes(char)) {
                return 'The string contains vowels.';
            }
        }
        return 'The string does not contain vowels.';
    };

    return (
        <div>
            <h3>Check if the given string contains any vowel:</h3>
            <p>{checkVowels(inputString)}</p>
        </div>
    );
};

export default VowelChecker;
