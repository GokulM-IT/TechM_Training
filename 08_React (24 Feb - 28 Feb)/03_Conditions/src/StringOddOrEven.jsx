export function StringOddOrEven({ string }) {
    return <h3>
        {string.length % 2 == 0 ? "String is even" : "String is odd"}
    </h3>
}