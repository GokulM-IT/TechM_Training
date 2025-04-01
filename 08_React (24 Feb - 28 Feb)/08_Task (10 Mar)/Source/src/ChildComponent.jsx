import React from 'react';

function ChildComponent({ data }) {
    return (
        <div>
            <h3>Data from API</h3>
            {data ? (
                <div className="api-data">
                    <p><strong>Title:</strong> {data.title}</p>
                    <p><strong>Body:</strong> {data.body}</p>
                </div>
            ) : (
                <p>Loading...</p>
            )}
        </div>
    );
}

export default ChildComponent;
