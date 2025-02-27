export function NumberDivisible({ num }) {
    return <>
        {num % 13 == 0 && <h3>{num} is divisible by 13</h3> || <h3>{num} is not divisible by 13</h3>}
    </>
}