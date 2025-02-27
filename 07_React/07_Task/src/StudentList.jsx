export function StudentList() {
    const students = [
        { name: "John Doe", department: "Computer Science" },
        { name: "Jane Smith", department: "Mathematics" },
        { name: "Samuel Green", department: "Physics" }
    ];

    return (
        <div>
            <h3>List of Students:</h3>
            <ul>
                {students.map((student, index) => (
                    <li key={index}>
                        {student.name} - {student.department}
                    </li>
                ))}
            </ul>
        </div>
    );
}
