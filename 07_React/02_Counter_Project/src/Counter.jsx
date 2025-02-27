import { useState } from "react"

export function Counter() {
    const [count, setCount] = useState(0)
    return <div onClick={() => setCount(currentCount => currentCount + 1)}> Count: {count}</div>
}